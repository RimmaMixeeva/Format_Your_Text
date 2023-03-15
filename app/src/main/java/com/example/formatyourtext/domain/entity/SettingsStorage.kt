package com.example.formatyourtext.domain.entity

import androidx.compose.runtime.Composable

class SettingsStorage private constructor(){
    val rowSettingRowModelList = mutableListOf<ItemSettingsRowModel>()
    val size = rowSettingRowModelList.size
    companion object {
        private val instance = SettingsStorage()
        fun getInstance(): SettingsStorage {return instance}
    }
    fun addRowSettingRowModel(item: ItemSettingsRowModel) {
        rowSettingRowModelList.add(item)
    }
}
