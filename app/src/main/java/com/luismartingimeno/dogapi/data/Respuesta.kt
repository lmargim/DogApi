package com.luismartingimeno.dogapi.data

data class Respuesta(
    val message: Map<String, List<String>>, // Map de razas y subrazas
    val status: String                      // Estado de la respuesta
)