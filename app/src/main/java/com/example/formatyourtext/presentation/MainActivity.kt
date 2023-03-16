package com.example.formatyourtext.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.formatyourtext.domain.useCase.fillSettingStorage

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fillSettingStorage()
        setContent {
            navController = rememberNavController()
            SetUpNavGraph(navController = navController)
    }
}
}
