package com.luismartingimeno.dogapi.data.repositories

import com.luismartingimeno.dogapi.data.Respuesta
import com.luismartingimeno.dogapi.data.model.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface RemoteService {
    @GET("breeds/list/all")
    suspend fun getBreeds(): Response<Respuesta>
//    @GET
//    suspend fun getDogsByBreeds(@Url url:String): Response<DogsResponse>
}
