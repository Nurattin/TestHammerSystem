package com.example.testhammersystem.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testhammersystem.navigation.TopLevelDestination
import com.example.testhammersystem.R
import com.example.testhammersystem.navigation.NavigationDestination
import com.example.testhammersystem.ui.screen.basket.navigation.BasketDestination
import com.example.testhammersystem.ui.screen.main.navigation.HomeDestination
import com.example.testhammersystem.ui.screen.user.navigation.UserDestination

@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController()
): AppState {
    return remember(navController) {
        AppState(navController)
    }
}

@Stable
class AppState(
    val navController: NavHostController
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val topLevelDestinations: List<TopLevelDestination> = listOf(
        TopLevelDestination(
            route = HomeDestination.route,
            destination = HomeDestination.destination,
            icon = R.drawable.ic_food,
            title = "Home",
        ),
        TopLevelDestination(
            route = UserDestination.route,
            destination = UserDestination.destination,
            icon = R.drawable.ic_user,
            title = "Category",
        ),
        TopLevelDestination(
            route = BasketDestination.route,
            destination = BasketDestination.destination,
            icon = R.drawable.ic_basket,
            title = "Category",
        )
    )


    /**
     * UI logic for navigating to a particular destination in the app. The NavigationOptions to
     * navigate with are based on the type of destination, which could be a top level destination or
     * just a regular destination.
     *
     * Top level destinations have only one copy of the destination of the back stack, and save and
     * restore state whenever you navigate to and from it.
     * Regular destinations can have multiple copies in the back stack and state isn't saved nor
     * restored.
     *
     * @param destination: The [NavigationDestination] the app needs to navigate to.
     * @param route: Optional route to navigate to in case the destination contains arguments.
     */

    fun navigate(destination: NavigationDestination, route: String? = null) {
        if (destination is TopLevelDestination) {
            navController.navigate(route ?: destination.route) {
                popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        } else {
            navController.navigate(route ?: destination.route)
        }
    }

    fun onBackClick() {
        navController.popBackStack()
    }
}