package com.example.testhammersystem.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.testhammersystem.domain.model.Food
import com.example.testhammersystem.ui.screen.main.Category


@Entity
data class FoodEntity(
    @PrimaryKey val id: String,
    val img: String,
    val name: String,
    val dsc: String,
    val price: Double,
    val category: String
) {
    fun toFood() = Food(
        id = id,
        img = img,
        name = name,
        dsc = dsc,
        price = price
    )
}
