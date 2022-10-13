package com.example.testhammersystem.ui.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testhammersystem.ui.screen.main.componet.HorizontalPagerWithOffsetTransition
import com.example.testhammersystem.ui.screen.main.componet.TopAppBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
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
    }

}



