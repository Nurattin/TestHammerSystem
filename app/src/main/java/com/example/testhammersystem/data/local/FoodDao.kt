package com.example.testhammersystem.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testhammersystem.data.local.entity.FoodEntity


@Dao
interface FoodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood(food: FoodEntity)

    @Query("SELECT * FROM foodentity WHERE category IN(:category)")
    suspend fun getFoodByCategory(category: String): List<FoodEntity>

}