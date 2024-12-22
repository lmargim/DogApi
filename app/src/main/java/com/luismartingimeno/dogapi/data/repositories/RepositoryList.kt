package com.luismartingimeno.dogapi.data.repositories

import com.luismartingimeno.dogapi.data.model.DogsResponse
import com.luismartingimeno.dogapi.data.repositories.RemoteConnection.remoteService

object RepositoryList {
    suspend fun getBreeds(): Map<String, List<String>> {
        return try {
            // Realizamos la llamada a la API
            val response = remoteService.getBreeds()
            if (response.isSuccessful) {
                // Procesamos la respuesta y devolvemos el mapa de razas y subrazas
                response.body()?.message ?: emptyMap() // Si el cuerpo es nulo, devuelve un mapa vacío
            } else {
                // Si la respuesta no fue exitosa, devolvemos un mapa vacío
                emptyMap()
            }
        } catch (e: Exception) {
            // Manejamos errores como problemas de red
            e.printStackTrace()
            emptyMap()
        }
    }
}
