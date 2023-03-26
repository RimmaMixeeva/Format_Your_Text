package com.example.formatyourtext.presentation.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.formatyourtext.domain.useCase.handleText
import com.example.formatyourtext.presentation.screens.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var liveText = MutableLiveData<String>()

    fun setNewText(item: String) {
        liveText.value = item
    }
    fun formatText(navController: NavController, context: Context) {
        viewModelScope.launch {
            handleText(context)
            withContext(Dispatchers.Main) {
                navController.navigate(Screen.Result.route)
            }
        }
    }

}