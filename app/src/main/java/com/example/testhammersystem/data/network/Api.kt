package com.example.testhammersystem.data.network

import com.example.testhammersystem.domain.model.Food
import retrofit2.http.GET
import kotlinx.coroutines.flow.Flow

interface Api {

    @GET("best-foods")
    suspend fun getBestFoods(): List<Food>

    @GET("burgers")
    suspend fun getBurgers(): List<Food>

    @GET("drinks")
    suspend fun getDrink(): List<Food>

    @GET("ice-cream")
    suspend fun getIceCream(): List<Food>

    @GET("pizzas")
    suspend fun getPizzas(): List<Food>

}