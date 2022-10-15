package com.example.testhammersystem.domain.use_case

import com.example.testhammersystem.domain.reposiroty.FoodsDataRepository
import com.example.testhammersystem.ui.screen.main.Category
import javax.inject.Inject

class GetFoodsDateUseCase @Inject constructor(
    private val repo: FoodsDataRepository,
) {
    operator fun invoke(category: Category) = repo.getFoodByCategory(category = category)
}