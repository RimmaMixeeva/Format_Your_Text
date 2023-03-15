package com.example.formatyourtext.domain.useCase

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.example.formatyourtext.data.dataStore.DataStoreManager
import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.domain.entity.TextStorage
import kotlinx.coroutines.*

suspend fun handleText(text: String, context: Context, scope: CoroutineScope): String {
    var storageList = SettingsStorage.getInstance().rowSettingRowModelList
    val dataStore = DataStoreManager(context)
    scope.launch(CoroutineName("transform text coroutine")) {
        for (item in storageList) {
                var savedSetting = dataStore.getSetting(item.id)
                if (savedSetting) {
                    transformThroughRegex(item.id)
                }
            }
        }
    return TextStorage.getInstance().text
}