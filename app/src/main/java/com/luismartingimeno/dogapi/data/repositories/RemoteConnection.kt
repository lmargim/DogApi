package com.luismartingimeno.dogapi.data.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RemoteConnection {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val remoteService: RemoteService = retrofit.create()

    suspend fun getBreedImage(breed: String): String? {
        return try {
            val response = if (breed.contains("/")) {
                val parts = breed.split("/")
                remoteService.getRandomImageBySubBreed(parts[0], parts[1])
            } else {
                remoteService.getRandomImageByBreed(breed)
            }

            if (response.isSuccessful) {
                response.body()?.message
            } else {
                null
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}
