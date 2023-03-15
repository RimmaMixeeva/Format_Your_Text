package com.example.formatyourtext.domain.useCase

import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.domain.entity.TextStorage
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.suspendCoroutine

fun transformThroughRegex(id: Int) {
    val textInstance = TextStorage.getInstance()
    val text = textInstance.text
    val storageList = SettingsStorage.getInstance().rowSettingRowModelList
    textInstance.setNewText(text.replace(storageList[id].regexBefore, storageList[id].regexAfter))
    //textInstance.setNewText(text + "1")
}
