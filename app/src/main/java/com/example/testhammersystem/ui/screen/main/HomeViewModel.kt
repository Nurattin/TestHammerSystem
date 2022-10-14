package com.example.testhammersystem.ui.screen.main

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private var _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val listCategory = listOf(
        CategoryChip(id = 1, title = "Пицца"),
        CategoryChip(id = 2, title = "Комбо"),
        CategoryChip(id = 3, title = "Десерты"),
        CategoryChip(id = 4, title = "Напитки"),
        CategoryChip(id = 5, title = "Бургеры"),
    )

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
                    selectedChip = listCategory.first()
                )
            )
        }
    }

    fun changeCategory(item: CategoryChip) {
        _uiState.update {
            it.copy(
                chipUiState = it.chipUiState.copy(
                    selectedChip = item
                )
            )
        }
    }

}


@Stable
data class HomeUiState(
    val bannerList: CollectionBannerList = CollectionBannerList(),
    val chipUiState: ChipUiState = ChipUiState()
)

@Immutable
data class CollectionBannerList(
    val value: List<String> = emptyList()
)

@Immutable
data class ChipUiState(
    val value: List<CategoryChip> = emptyList(),
    val selectedChip: CategoryChip? = null
)

data class CategoryChip(
    val id: Int,
    val title: String
)


