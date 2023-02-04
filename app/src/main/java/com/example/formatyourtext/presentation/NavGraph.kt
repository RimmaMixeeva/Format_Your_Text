package com.example.formatyourtext.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.formatyourtext.presentation.screens.MainScreen
import com.example.formatyourtext.presentation.screens.ResultScreen
import com.example.formatyourtext.presentation.screens.Screen
import com.example.formatyourtext.presentation.screens.SettingsScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController
) {
  NavHost(navController = navController , startDestination = Screen.Main.route) {
      composable(
          route = Screen.Main.route
      ) {
          MainScreen(navController)
      }
      composable(
          route = Screen.Result.route + "/{text}",
          arguments = listOf(
              navArgument("text"){
                  type = NavType.StringType
                  nullable = false
              })

      ) { entry ->
          entry.arguments?.getString("text")?.let { ResultScreen(navController, text = it) }
      }
      composable(
          route = Screen.Settings.route
      ) {
          SettingsScreen(navController)
      }

  }
}