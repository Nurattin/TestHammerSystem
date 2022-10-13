package com.example.testhammersystem.navigation

import androidx.annotation.DrawableRes
import com.example.testhammersystem.navigation.NavigationDestination


/**
 * Each of these destinations
 * can contain one or more screens
 */
data class TopLevelDestination(
    override val route: String,
    override val destination: String,
    val icon: Int,
    val title: String,
): NavigationDestination