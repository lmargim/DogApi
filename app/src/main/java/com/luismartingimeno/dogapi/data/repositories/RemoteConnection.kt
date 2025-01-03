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
        val response = remoteService.getRandomImageByBreed(breed)
        return if (response.isSuccessful) {
            response.body()?.message
        } else {
            null
        }
    }
}
