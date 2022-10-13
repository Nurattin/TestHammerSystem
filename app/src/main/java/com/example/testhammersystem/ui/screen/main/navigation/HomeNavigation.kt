package com.example.testhammersystem.ui.screen.main.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.testhammersystem.navigation.NavigationDestination
import com.example.testhammersystem.ui.screen.main.HomeViewModel
import com.example.testhammersystem.ui.screen.main.HomeScreen


object HomeDestination : NavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}


fun NavGraphBuilder.homeGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit
) {

    navigation(
        route = HomeDestination.route,
        startDestination = HomeDestination.destination
    ) {
        composable(route = HomeDestination.destination) {
            val mainViewModel = hiltViewModel<HomeViewModel>()
            HomeScreen(viewModel = mainViewModel)
        }
        nestedGraphs()
    }
}