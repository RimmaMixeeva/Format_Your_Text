package com.example.formatyourtext.domain.useCase

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.example.formatyourtext.data.dataStore.DataStoreManager
import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.presentation.viewModel.MainViewModel


suspend fun handleText(context: Context): String {

    var mainViewModel = ViewModelProvider(context as ComponentActivity)[MainViewModel::class.java]

    var storageList = SettingsStorage.rowSettingRowModelList
    val dataStore = DataStoreManager(context)
        for (item in storageList) {
                var savedSetting = dataStore.getSetting(item.id)
                if (savedSetting) {
                    val text = mainViewModel.liveText.value ?: ""
                    val storageList = SettingsStorage.rowSettingRowModelList
                    mainViewModel.setNewText(text.replace(storageList[item.id].regexBefore, storageList[item.id].regexAfter))
                }
            }
    return mainViewModel.liveText.value ?: ""
}