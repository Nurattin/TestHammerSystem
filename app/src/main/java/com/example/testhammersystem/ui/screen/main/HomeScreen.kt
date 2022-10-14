package com.example.testhammersystem.ui.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.testhammersystem.ui.screen.main.componet.CategoryChipGroup
import com.example.testhammersystem.ui.screen.main.componet.HorizontalPagerWithOffsetTransition
import com.example.testhammersystem.ui.screen.main.componet.TopAppBar

@OptIn(ExperimentalFoundationApi::class, ExperimentalLifecycleComposeApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    with(uiState) {
        LazyColumn(modifier = modifier) {
            item { TopAppBar() }
            item {
                HorizontalPagerWithOffsetTransition(
                    modifier = Modifier.padding(
                        top = 16.dp,
                        bottom = 24.dp
                    )
                )
            }
            stickyHeader {
                CategoryChipGroup(
                    modifier = modifier
                        .padding(bottom = 16.dp),
                    listChip = chipUiState.value,
                    selectedChip = chipUiState.selectedChip,
                    onClickChip = viewModel::changeCategory
                )
            }
            item {
                Divider(modifier = Modifier.fillMaxWidth())
            }
        }
    }

}



