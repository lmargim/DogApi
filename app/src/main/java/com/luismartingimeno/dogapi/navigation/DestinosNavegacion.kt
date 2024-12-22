package com.luismartingimeno.dogapi.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
data class Home(val nombreUsuario: String)

@Serializable
data class BreedDetail(val nombreUsuario: String, val breed: String)