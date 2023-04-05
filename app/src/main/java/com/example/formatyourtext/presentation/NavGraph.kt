package com.example.formatyourtext.presentation

import android.transition.Slide
import android.transition.Transition
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.formatyourtext.presentation.screens.*
import com.example.formatyourtext.presentation.viewModel.MainViewModel
import java.time.zone.ZoneOffsetTransition

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    viewModel: MainViewModel,
) {
  NavHost(navController = navController , startDestination = Screen.Main.route) {
      composable(
          route = Screen.Main.route
      ) {
          MainScreen(navController, viewModel)
      }
      composable(
          route = Screen.Result.route
      ) { ResultScreen(navController, viewModel)
      }
      composable(
          route = Screen.Settings.route
      ) {
          SettingsScreen(navController)
      }

  }
}