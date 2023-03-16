package com.example.formatyourtext.domain.useCase

import com.example.formatyourtext.domain.entity.SettingsStorage
import com.example.formatyourtext.domain.entity.TextStorage

fun transformThroughRegex(id: Int) {
    val text = TextStorage.text
    val storageList = SettingsStorage.rowSettingRowModelList
    TextStorage.setNewText(text.replace(storageList[id].regexBefore, storageList[id].regexAfter))
}
