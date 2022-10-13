package com.example.testhammersystem.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.testhammersystem.navigation.HomeNavHost
import com.example.testhammersystem.navigation.TopLevelDestination
import com.example.testhammersystem.ui.theme.BottomBarBackgroundColor
import com.example.testhammersystem.ui.theme.BottomBarItem
import com.example.testhammersystem.ui.theme.Primary

@Composable
fun AppScreen() {

    val appState: AppState = rememberAppState()

    Scaffold(
        bottomBar = {
            HomeBottomBar(
                destinations = appState.topLevelDestinations,
                onNavigateToDestination = appState::navigate,
                currentDestination = appState.currentDestination
            )
        },
    ) { innerPadding ->
        HomeNavHost(
            navController = appState.navController,
            onBackClick = appState::onBackClick,
            onNavigateToDestination = appState::navigate,
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?
) {
    BottomNavigation(
        backgroundColor = BottomBarBackgroundColor
    ) {
        destinations.forEach { destination ->
            BottomNavigationItem(
                selectedContentColor = Primary,
                unselectedContentColor = BottomBarItem,
                selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    Icon(
                        modifier = Modifier
                            .size(22.dp),
                        painter = painterResource(id = destination.icon),
                        contentDescription = null,
                    )
                },
                label = {
                    Text(
                        modifier = Modifier.padding(horizontal = 15.dp),
                        text = destination.title,
                        style = MaterialTheme.typography.body2,
                    )
                })
        }
    }
}
