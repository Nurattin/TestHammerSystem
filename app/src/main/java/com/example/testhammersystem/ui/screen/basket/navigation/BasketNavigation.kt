package com.example.testhammersystem.ui.screen.basket.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.testhammersystem.navigation.NavigationDestination
import com.example.testhammersystem.ui.screen.basket.BasketScreen
import com.example.testhammersystem.ui.screen.user.UserScreen


object BasketDestination : NavigationDestination {
    override val route = "basket_route"
    override val destination = "basket_destination"
}


fun NavGraphBuilder.basketGraph(
    nestedGraphs: NavGraphBuilder.() -> Unit
) {

    navigation(
        route = BasketDestination.route,
        startDestination = BasketDestination.destination
    ) {
        composable(route = BasketDestination.destination) {
            BasketScreen()
        }
        nestedGraphs()
    }
}