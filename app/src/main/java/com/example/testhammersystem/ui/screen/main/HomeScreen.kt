package com.example.testhammersystem.ui.screen.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.testhammersystem.ui.screen.main.componet.TopAppBar

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel
) {
    LazyColumn(modifier = modifier){
        item { TopAppBar() }
    }

}



