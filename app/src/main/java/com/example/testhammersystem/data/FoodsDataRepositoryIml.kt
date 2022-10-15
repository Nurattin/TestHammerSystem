package com.example.testhammersystem.data

import com.example.testhammersystem.data.di.IoDispatcher
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
) : FoodsDataRepository {
    override fun getFoodByCategory(category: Category): Flow<List<Food>> = flow<List<Food>> {
        emit(
            when (category) {
                Category.BestFood -> {
                    api.getBestFoods()
                }
                Category.Burgers -> {
                    api.getBurgers()
                }
                Category.Pizzas -> {
                    api.getPizzas()
                }
                Category.Drinks -> {
                    api.getDrink()
                }
                Category.IceCream -> {
                    api.getIceCream()
                }
            }
        )
    }.flowOn(ioDispatcher)
}
