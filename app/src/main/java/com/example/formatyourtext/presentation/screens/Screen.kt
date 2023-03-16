package com.example.formatyourtext.presentation.screens

sealed class Screen (val route: String) {
    object Main: Screen(route = "main_screen")
    object Result: Screen(route = "result_screen")
    object Settings: Screen(route = "settings_screen")
}