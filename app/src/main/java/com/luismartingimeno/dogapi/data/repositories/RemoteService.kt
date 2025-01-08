package com.luismartingimeno.dogapi.data.repositories

import com.luismartingimeno.dogapi.data.model.Respuesta
import com.luismartingimeno.dogapi.data.model.RespuestaImagenAleatoria
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService {
    @GET("breeds/list/all")
    suspend fun getBreeds(): Response<Respuesta>

    // Razas principales
    @GET("breed/{breed}/images/random")
    suspend fun getRandomImageByBreed(@Path("breed") breed: String): Response<RespuestaImagenAleatoria>

    // Subrazas
    @GET("breed/{mainBreed}/{subBreed}/images/random")
    suspend fun getRandomImageBySubBreed(
        @Path("mainBreed") mainBreed: String,
        @Path("subBreed") subBreed: String
    ): Response<RespuestaImagenAleatoria>
}
