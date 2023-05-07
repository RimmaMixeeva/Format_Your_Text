package com.example.formatyourtext.presentation.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.formatyourtext.data.database.appDataBase.AppDatabase
import com.example.formatyourtext.data.database.entities.AppRegex
import com.example.formatyourtext.data.database.entities.Setting
import com.example.formatyourtext.data.database.repository.SettingRepository
import com.example.formatyourtext.domain.useCase.handleText
import com.example.formatyourtext.presentation.navigation.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) : AndroidViewModel(application) {


    var readAllData: LiveData<List<Setting>>
    var readAllRegex: LiveData<List<AppRegex>>
    private val repository: SettingRepository

    init {
        val settingDao = AppDatabase.getDbInstance(application).settingDao()
        repository = SettingRepository(settingDao)
        readAllData = repository.readAllData
        readAllRegex = repository.readAllRegex
    }

    var liveText = MutableLiveData<String>()

    fun setNewText(item: String) {
        liveText.value = item
    }

    fun upsertSetting(setting: Setting) {
        viewModelScope.launch {
            repository.upsertData(setting)
        }
    }

    fun formatText(navController: NavController, viewModel: MainViewModel) {
        viewModelScope.launch {
            handleText(viewModel)
            withContext(Dispatchers.Main) {
                navController.navigate(Screen.Result.route)
            }
        }
    }
}