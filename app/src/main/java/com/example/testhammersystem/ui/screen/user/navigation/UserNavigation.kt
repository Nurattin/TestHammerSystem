package com.example.testhammersystem.ui.screen.user.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.testhammersystem.navigation.NavigationDestination
import com.example.testhammersystem.ui.screen.main.HomeViewModel
import com.example.testhammersystem.ui.screen.user.UserScreen


object UserDestination : NavigationDestination {
    override val route = "user_route"
    override val destination = "user_destination"
}


fun NavGraphBuilder.userGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit
) {

    navigation(
        route = UserDestination.route,
        startDestination = UserDestination.destination
    ) {
        composable(route = UserDestination.destination) {
            UserScreen()
        }
        nestedGraphs()
    }
}