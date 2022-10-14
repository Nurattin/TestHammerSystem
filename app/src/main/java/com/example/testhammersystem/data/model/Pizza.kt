package com.example.testhammersystem.data.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Food(
    @SerialName("id")
    val id: String,
    @SerialName("img")
    val img: String,
    @SerialName("name")
    val name: String,
    @SerialName("dsc")
    val dsc: String,
    @SerialName("price")
    val price: Double
)
