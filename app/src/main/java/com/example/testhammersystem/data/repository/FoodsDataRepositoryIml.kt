package com.example.testhammersystem.data.repository

import com.example.testhammersystem.data.di.IoDispatcher
import com.example.testhammersystem.data.local.FoodDao
import com.example.testhammersystem.data.local.FoodDatabase
import com.example.testhammersystem.data.network.Api
import com.example.testhammersystem.domain.model.Food
import com.example.testhammersystem.domain.reposiroty.FoodsDataRepository
import com.example.testhammersystem.ui.screen.main.Category
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class FoodsDataRepositoryIml @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val api: Api,
    private val dao: FoodDao
) : FoodsDataRepository {
    override fun getFoodByCategory(category: Category): Flow<List<Food>> = flow {
        emit(
            when (category) {
                Category.BestFood -> {
                    try {
                        api.getBestFoods().map {
                            dao.insertFood(it.toFoodEntity(category.cat))
                            it.toFood()
                        }
                    } catch (e: java.lang.Exception) {
                        dao.getFoodByCategory(category = category.cat).map { it.toFood() }
                    }
                }
                Category.Burgers -> {
                    try {
                        api.getBurgers().map {
                            dao.insertFood(it.toFoodEntity(category.cat))
                            it.toFood()
                        }
                    } catch (e: java.lang.Exception) {
                        dao.getFoodByCategory(category = category.cat).map { it.toFood() }
                    }
                }
                Category.Pizzas -> {
                    try {
                        api.getPizzas().map {
                            dao.insertFood(it.toFoodEntity(category.cat))
                            it.toFood()
                        }
                    } catch (e: java.lang.Exception) {
                        dao.getFoodByCategory(category = category.cat).map { it.toFood() }
                    }
                }
                Category.Drinks -> {
                    try {
                        api.getDrink().map {
                            dao.insertFood(it.toFoodEntity(category.cat))
                            it.toFood()
                        }
                    } catch (e: java.lang.Exception) {
                        dao.getFoodByCategory(category = category.cat).map { it.toFood() }
                    }
                }
                Category.IceCream -> {
                    try {
                        api.getIceCream().map {
                            dao.insertFood(it.toFoodEntity(category.cat))
                            it.toFood()
                        }
                    } catch (e: java.lang.Exception) {
                        dao.getFoodByCategory(category = category.cat).map { it.toFood() }
                    }
                }
            }
        )
    }.flowOn(ioDispatcher)
}
