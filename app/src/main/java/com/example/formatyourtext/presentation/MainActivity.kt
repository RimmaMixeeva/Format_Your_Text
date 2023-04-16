package com.example.formatyourtext.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.formatyourtext.presentation.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.readAllData.observe(this) {
            mainViewModel.fillSettingStorage()
        }
        mainViewModel.readAllRegex.observe(this) {
            mainViewModel.fillRegexStorage()
        }
        setContent {
            navController = rememberNavController()
            SetUpNavGraph(navController = navController, mainViewModel)
        }
    }
}
