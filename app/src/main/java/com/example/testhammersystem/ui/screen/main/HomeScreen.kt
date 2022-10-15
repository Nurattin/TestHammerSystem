package com.example.testhammersystem.ui.screen.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.testhammersystem.ui.screen.main.componet.CategoryChipGroup
import com.example.testhammersystem.ui.screen.main.componet.FoodDetail
import com.example.testhammersystem.ui.screen.main.componet.HorizontalPagerWithOffsetTransition
import com.example.testhammersystem.ui.screen.main.componet.TopAppBar


@OptIn(ExperimentalFoundationApi::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val scrollState = rememberLazyListState()

    LaunchedEffect(
        key1 = uiState.foodsList.value
    ) {
        if (scrollState.firstVisibleItemIndex > 2) {
            scrollState.animateScrollToItem(1)
        }
    }

    with(uiState) {
        Column(modifier = modifier) {
            TopAppBar(
                onClickQrCode = {
                    try {
                        val intent = Intent("com.google.zxing.client.android.SCAN")
                        intent.putExtra("SCAN_MODE", "QR_CODE_MODE")
                        startActivity(context, intent, null)
                    } catch (e: Exception) {
                        val marketUri =
                            Uri.parse("market://details?id=com.google.zxing.client.android")
                        val marketIntent = Intent(Intent.ACTION_VIEW, marketUri)
                        startActivity(context, marketIntent, null)
                    }
                },
                onClickDropDown = viewModel::dropDownMenuIsVisibly,
                selectCity = dropDownUiState.selectedCity,
                onDismissRequest = viewModel::dropDownMenuIsVisibly,
                onClickCity = viewModel::changeCity,
                listCity = dropDownUiState.listCity,
                dropDownExpanded = dropDownUiState.isVisibility
            )
            LazyColumn(
                state = scrollState
            ) {
                item {
                    HorizontalPagerWithOffsetTransition(
                        modifier = Modifier.padding(
                            top = 16.dp,
                            bottom = 24.dp
                        ),
                        listBanners = bannerList.value
                    )
                }
                stickyHeader {
                    CategoryChipGroup(
                        modifier = modifier.fillMaxWidth(),
                        listChip = chipUiState.value,
                        selectedChip = chipUiState.selectedChip.cat,
                        onClickChip = viewModel::changeCategory
                    )
                }
                item {
                    Divider(modifier = Modifier.fillMaxWidth())
                }

                items(items = foodsList.value) { food ->
                    FoodDetail(food = food)
                    Divider(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFFF3F5F9)
                    )
                }
            }
        }
    }
}



