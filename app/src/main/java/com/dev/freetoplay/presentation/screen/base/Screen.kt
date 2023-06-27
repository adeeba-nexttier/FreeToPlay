package com.dev.freetoplay.presentation.screen.base

sealed class Screen(
    val route: String
) {
    object HomeScreen: Screen(route = "")
}
