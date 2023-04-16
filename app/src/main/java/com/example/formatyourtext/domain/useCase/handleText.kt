package com.example.formatyourtext.domain.useCase


import android.content.Context
import android.util.Log
import com.example.formatyourtext.data.dataStore.DataStoreManager
import com.example.formatyourtext.data.database.repository.SettingRepository
import com.example.formatyourtext.domain.entity.ItemSettingsRowModel
import com.example.formatyourtext.domain.entity.RegexModel
import com.example.formatyourtext.domain.repository.RegexStorage
import com.example.formatyourtext.domain.repository.SettingsStorage
import com.example.formatyourtext.presentation.viewModel.MainViewModel

suspend fun handleText(context: Context, mainViewModel: MainViewModel, repository: SettingRepository): String {
    val storageList = SettingsStorage.rowSettingRowModelList
    val dataStore = DataStoreManager(context)
    for (item in storageList) {
        val savedSetting = dataStore.getSetting(item.id)
        if (savedSetting) {
            Log.i("oiiii", item.id.toString())
        var regexes = RegexStorage.RegexModelList.filter { one -> one.settingId == item.id }.sortedBy { it.priority }
            for (i in 0 until regexes.size) {
                Log.i("regex before", regexes[i].regexBefore)
                val text = mainViewModel.liveText.value ?: ""
                mainViewModel.setNewText(
                        text.replace(
                            Regex(regexes[i].regexBefore),
                            regexes[i].regexAfter,
                        )
                    )
            }
        }
    }
    return mainViewModel.liveText.value ?: ""
}