package com.example.testhammersystem.data.network.dto


import androidx.annotation.Keep
import com.example.testhammersystem.data.local.entity.FoodEntity
import com.example.testhammersystem.domain.model.Food
import com.example.testhammersystem.ui.screen.main.Category
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Keep
data class FoodDto(
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
) {
    fun toFood() = Food(
        id = id,
        img = img,
        name = name,
        dsc = dsc,
        price = price
    )
    fun toFoodEntity(category: String) = FoodEntity(
        id = id,
        img = img,
        name = name,
        dsc = dsc,
        price = price,
        category = category
    )
}