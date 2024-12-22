package com.luismartingimeno.dogapi.data.repositories

import com.luismartingimeno.dogapi.data.Respuesta
import com.luismartingimeno.dogapi.data.RespuestaImagenAleatoria
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService {
    @GET("breeds/list/all")
    suspend fun getBreeds(): Response<Respuesta>

    @GET("breed/{breed}/images/random")
    suspend fun getRandomImageByBreed(@Path("breed") breed: String): Response<RespuestaImagenAleatoria>

}
