package com.luismartingimeno.dogapi.data.model

import com.google.gson.annotations.SerializedName

data class DogsResponse(
    @SerializedName("message")
    val image: String,
    @SerializedName("status")
    val status: String
)