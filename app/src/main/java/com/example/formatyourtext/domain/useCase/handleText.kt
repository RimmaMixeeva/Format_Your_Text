package com.example.formatyourtext.domain.useCase


import android.content.Context
import com.example.formatyourtext.data.dataStore.DataStoreManager
import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.presentation.viewModel.MainViewModel

suspend fun handleText(context: Context, mainViewModel: MainViewModel): String {

    val storageList = SettingsStorage.rowSettingRowModelList
    val dataStore = DataStoreManager(context)
    for (item in storageList) {
        val savedSetting = dataStore.getSetting(item.id)
        if (savedSetting) {
            val text = mainViewModel.liveText.value ?: ""
            mainViewModel.setNewText(
                text.replace(
                    storageList[item.id].regexBefore,
                    storageList[item.id].regexAfter.toString()
                )
            )
        }
    }
    return mainViewModel.liveText.value ?: ""
}