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

    private val listFoods = _uiState.value.foodsList.getMockData()
    private val listCity = _uiState.value.dropDownUiState.getMockData()

    private val listBanner = listOf(
        "https://www.lifescapepremier.com/hubfs/iStock-835842214.jpg",
        "https://images.freeclues.com/assets/images/coupons/coupon_d5896d2fa2d3b567695acbca6fcadf42.jpg",
        "https://f.roocdn.com/images/menus/500642/header-image.jpg?width=1200&amp;height=630&amp;auto=webp&amp;format=jpg&amp;fit=crop&amp;v=1616506412",
        "https://avatars.mds.yandex.net/get-zen_doc/1586459/pub_5dded3b421cd6d24351dab4b_5dded4d416376423cc9592c6/scale_1200"
    )


    init {

        _uiState.update {
            it.copy(
                bannerList = it.bannerList.copy(
                    value = listBanner,
                ),
                chipUiState = it.chipUiState.copy(
                    value = listCategory,
                ),
                foodsList = it.foodsList.copy(
                    value = listFoods
                ),
                dropDownUiState = it.dropDownUiState.copy(
                    listCity = listCity,
                    selectedCity = listCity.first()
                )
            )
        }
    }


    fun changeCategory(item: Category) {

        viewModelScope.launch {
            getFoodsUseCase(item).asResult().collect {
                when(val result = it){
                    is Result.Error -> {}
                    is Result.Loading -> {}
                    is Result.Success -> {_uiState.update { currentState ->
                        currentState.copy(
                            chipUiState = currentState.chipUiState.copy(
                                selectedChip = item,
                            ),
                            foodsList = currentState.foodsList.copy(
                                value = result.data
                            )
                        )
                    }}
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
    val dropDownUiState: DropDownUiState = DropDownUiState()

)

@Immutable
data class CollectionBannerList(
    val value: List<String> = emptyList()
)

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
)
enum class Category(val cat: String) {
    BestFood("Популярные"),
    Burgers("Бургеры"),
    Pizzas("Пицца"),
    Drinks("Напитки"),
    IceCream("Мороженное")
}



