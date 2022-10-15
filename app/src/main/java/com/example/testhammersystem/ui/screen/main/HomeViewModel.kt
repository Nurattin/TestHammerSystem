package com.example.testhammersystem.ui.screen.main

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testhammersystem.data.result.Result
import com.example.testhammersystem.data.result.asResult
import com.example.testhammersystem.domain.model.Food
import com.example.testhammersystem.domain.use_case.GetFoodsDateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFoodsUseCase: GetFoodsDateUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val listCategory = Category.values().map { it }

    private val listCity = _uiState.value.dropDownUiState.getMockData()

    private val listBanner = _uiState.value.bannerList.getMockData()

    init {
        _uiState.update {
            it.copy(
                bannerList = it.bannerList.copy(
                    value = listBanner,
                ),
                chipUiState = it.chipUiState.copy(
                    value = listCategory,
                ),
                dropDownUiState = it.dropDownUiState.copy(
                    listCity = listCity,
                    selectedCity = listCity.first()
                )
            )
        }
        changeCategory(Category.BestFood)
    }


    fun changeCategory(item: Category) {

        viewModelScope.launch {
            getFoodsUseCase(item).asResult().collect {
                when (val result = it) {
                    is Result.Error -> {}
                    is Result.Loading -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                isLoading = true,
                                chipUiState = currentState.chipUiState.copy(
                                    loadingChip = item
                                )
                            )
                        }
                    }
                    is Result.Success -> {
                        _uiState.update { currentState ->
                            currentState.copy(
                                chipUiState = currentState.chipUiState.copy(
                                    selectedChip = item,
                                    loadingChip = null
                                ),
                                foodsList = currentState.foodsList.copy(
                                    value = result.data
                                ),
                                isLoading = false
                            )
                        }
                    }
                }
            }
        }
    }

    fun changeCity(city: String) {
        _uiState.update {
            it.copy(
                dropDownUiState = it.dropDownUiState.copy(
                    selectedCity = city,
                    isVisibility = false
                )
            )
        }
    }

    fun dropDownMenuIsVisibly() {
        _uiState.update {
            it.copy(
                dropDownUiState = it.dropDownUiState.copy(
                    isVisibility = !it.dropDownUiState.isVisibility
                )
            )
        }
    }

}


@Stable
data class HomeUiState(
    val bannerList: CollectionBannerList = CollectionBannerList(),
    val chipUiState: ChipUiState = ChipUiState(),
    val foodsList: CollectionFoodsList = CollectionFoodsList(),
    val dropDownUiState: DropDownUiState = DropDownUiState(),
    val isLoading: Boolean = false,

    )

@Immutable
data class CollectionBannerList(
    val value: List<String> = emptyList()
) {
    fun getMockData() = listOf(
        "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
        "https://st03.kakprosto.ru/images/article/2018/11/19/69536_5bf2ff2d130e15bf2ff2d1311d.jpeg",
        "https://i6.photo.2gis.com/images/branch/0/30258560052036566_00e7.jpg",
        "https://st03.kakprosto.ru/images/article/2018/11/19/69536_5bf2ff2d130e15bf2ff2d1311d.jpeg"
    )

}

@Immutable
data class DropDownUiState(
    val isVisibility: Boolean = false,
    val listCity: List<String> = emptyList(),
    val selectedCity: String = ""
) {
    fun getMockData(): List<String> {
        return listOf(
            "Москва",
            "Махачкала",
            "Ростов",
            "Краснодар",
            "Котлин"
        )
    }
}

@Immutable
data class CollectionFoodsList(
    val value: List<Food> = emptyList()
) {
    fun getMockData(): List<Food> {
        return listOf(
            Food(
                id = "1",
                img = "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
                name = "Ветчина и грибы",
                dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345.0
            ),
            Food(
                id = "1",
                img = "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
                name = "Ветчина и грибы",
                dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345.0
            ),
            Food(
                id = "1",
                img = "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
                name = "Ветчина и грибы",
                dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345.0
            ),
            Food(
                id = "1",
                img = "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
                name = "Ветчина и грибы",
                dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345.0
            ),
            Food(
                id = "1",
                img = "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
                name = "Ветчина и грибы",
                dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345.0
            ),
            Food(
                id = "1",
                img = "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
                name = "Ветчина и грибы",
                dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345.0
            ),
            Food(
                id = "1",
                img = "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
                name = "Ветчина и грибы",
                dsc = "Ветчина,шампиньоны, увеличинная порция моцареллы, томатный соус",
                price = 345.0
            )
        )
    }
}

@Immutable
data class ChipUiState(
    val value: List<Category> = emptyList(),
    val selectedChip: Category = Category.BestFood,
    val loadingChip: Category? = null
)

enum class Category(val cat: String) {
    BestFood("Популярные"),
    Burgers("Бургеры"),
    Pizzas("Пицца"),
    Drinks("Напитки"),
    IceCream("Мороженное")
}



