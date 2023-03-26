package com.example.formatyourtext.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.formatyourtext.domain.useCase.fillSettingStorage
import com.example.formatyourtext.presentation.viewModel.MainViewModel

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    lateinit var mainViewModwl: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        fillSettingStorage()
        setContent {
            navController = rememberNavController()
            SetUpNavGraph(navController = navController, mainViewModel)
    }
}
}
