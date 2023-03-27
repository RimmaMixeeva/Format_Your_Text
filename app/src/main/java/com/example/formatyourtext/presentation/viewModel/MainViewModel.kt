package com.example.formatyourtext.presentation.viewModel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.formatyourtext.data.database.appDataBase.AppDatabase
import com.example.formatyourtext.data.database.entities.Setting
import com.example.formatyourtext.data.database.repository.SettingRepository
import com.example.formatyourtext.domain.entity.ItemSettingsRowModel
import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.domain.useCase.handleText
import com.example.formatyourtext.presentation.screens.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application) : AndroidViewModel(application) {


    var readAllData: LiveData<List<Setting>>
    private val repository: SettingRepository

    init {
        val settingDao = AppDatabase.getDbInstance(application).settingDao()
        repository = SettingRepository(settingDao)
        readAllData = repository.readAllData
    }

    var liveText = MutableLiveData<String>()

    fun setNewText(item: String) {
        liveText.value = item
    }

    fun formatText(navController: NavController, context: Context, viewModel: MainViewModel) {
        viewModelScope.launch {
            handleText(context, viewModel)
            withContext(Dispatchers.Main) {
                navController.navigate(Screen.Result.route)
            }
        }
    }

    fun fillSettingStorage() {
        var array = ArrayList<ItemSettingsRowModel>()
        readAllData.value?.map { item -> item.toItemSettingsRowModel() }
            ?.forEach { item -> array.add(item) }
        SettingsStorage.addRowSettingRowModels(array)
    }
}