package com.example.testhammersystem.data.network

import com.example.testhammersystem.data.network.dto.FoodDto
import retrofit2.http.GET

interface Api {

    @GET("best-foods")
    suspend fun getBestFoods(): List<FoodDto>

    @GET("burgers")
    suspend fun getBurgers(): List<FoodDto>

    @GET("drinks")
    suspend fun getDrink(): List<FoodDto>

    @GET("ice-cream")
    suspend fun getIceCream(): List<FoodDto>

    @GET("pizzas")
    suspend fun getPizzas(): List<FoodDto>

}