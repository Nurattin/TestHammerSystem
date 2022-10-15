package com.example.testhammersystem.domain.model


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Keep
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
