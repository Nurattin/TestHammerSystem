package com.example.testhammersystem.ui.screen.main

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.testhammersystem.ui.screen.main.componet.CategoryChipGroup
import com.example.testhammersystem.ui.screen.main.componet.FoodDetail
import com.example.testhammersystem.ui.screen.main.componet.HorizontalPagerWithOffsetTransition
import com.example.testhammersystem.ui.screen.main.componet.TopAppBar
import com.example.testhammersystem.ui.theme.InactiveElement


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
            scrollState.animateScrollToItem(2)
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
                        modifier = modifier
                            .fillMaxWidth()
                            .drawBehind {
                                this.drawIntoCanvas {

                                }
                            },
                        listChip = chipUiState.value,
                        selectedChip = chipUiState.selectedChip.cat,
                        onClickChip = viewModel::changeCategory,
                        loadingChip = chipUiState.loadingChip
                    )
                }
                item {
                    Divider(modifier = Modifier.fillMaxWidth())
                }
                if (isLoading) {
                    items(count = 4) {
                        FoodDetail(
                            isLoading = true
                        )
                    }
                } else if (foodsList.value.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                style = MaterialTheme.typography.subtitle2,
                                color = InactiveElement,
                                text = "Список пуст или проверьте подключение к интернету"
                            )
                        }
                    }
                } else {
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
}



