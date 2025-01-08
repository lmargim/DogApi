package com.luismartingimeno.dogapi.Screens.BreedDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luismartingimeno.dogapi.data.repositories.RemoteConnection
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BreedDetailViewModel : ViewModel() {
    private val _breedImage = MutableStateFlow<String?>(null)
    val breedImage: StateFlow<String?> get() = _breedImage

    // Aqui hacemos el fetch con la raza seleccionada
    fun fetchBreedImage(breed: String) {
        viewModelScope.launch {
            try {
                val normalizedBreed = breed.split(" ").let { parts ->
                    if (parts.size == 2) {
                        "${parts[0]}/${parts[1]}" // MainBreed/SubBreed
                    } else {
                        breed // razas simples
                    }
                }

                val imageUrl = RemoteConnection.getBreedImage(normalizedBreed)
                _breedImage.value = imageUrl
            } catch (e: Exception) {
                e.printStackTrace()
                _breedImage.value = null
            }
        }
    }
}
