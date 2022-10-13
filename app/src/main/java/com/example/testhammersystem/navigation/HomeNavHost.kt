package com.example.testhammersystem.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.testhammersystem.ui.screen.basket.navigation.basketGraph
import com.example.testhammersystem.ui.screen.main.navigation.HomeDestination
import com.example.testhammersystem.ui.screen.main.navigation.homeGraph
import com.example.testhammersystem.ui.screen.user.navigation.userGraph


@Composable
fun HomeNavHost(
    navController: NavHostController,
    onNavigateToDestination: (NavigationDestination) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = HomeDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        homeGraph { }
        userGraph { }
        basketGraph { }
    }
}