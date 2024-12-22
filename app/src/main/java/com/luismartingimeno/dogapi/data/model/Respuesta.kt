package com.luismartingimeno.dogapi.data.model

data class Respuesta(
    // Razas y subrazas
    val message: Map<String, List<String>>,
    val status: String
)