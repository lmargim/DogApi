package com.luismartingimeno.dogapi.Screens.HomeScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luismartingimeno.dogapi.data.repositories.RemoteConnection
import kotlinx.coroutines.launch

class BreedsViewModel : ViewModel() {

    private val _breeds: MutableLiveData<List<String>> = MutableLiveData()
    val breeds: LiveData<List<String>> = _breeds

    private val _progressBar: MutableLiveData<Boolean> = MutableLiveData(false)
    val progressBar: LiveData<Boolean> = _progressBar

    init {
        fetchBreeds()
    }

    private fun fetchBreeds() {
        viewModelScope.launch {
            _progressBar.value = true
            try {
                val response = RemoteConnection.remoteService.getBreeds()
                if (response.isSuccessful) {
                    val breedsMap = response.body()?.message ?: emptyMap()
                    val breedsList = breedsMap.flatMap { (breed, subBreeds) ->
                        if (subBreeds.isEmpty()) listOf(breed) // Si no hay subrazas, solo agrega la raza
                        else subBreeds.map { "$breed $it" } // Combina raza y subraza
                    }
                    _breeds.value = breedsList.sorted() // Ordena la lista alfabéticamente
                } else {
                    _breeds.value = emptyList() // En caso de error, lista vacía
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _breeds.value = emptyList()
            } finally {
                _progressBar.value = false
            }
        }
    }
}
