package com.example.testhammersystem.domain.reposiroty

import com.example.testhammersystem.domain.model.Food
import com.example.testhammersystem.ui.screen.main.Category
import kotlinx.coroutines.flow.Flow

interface FoodsDataRepository {
    fun getFoodByCategory(category: Category): Flow<List<Food>>
}
