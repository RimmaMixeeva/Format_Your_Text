package com.example.formatyourtext.domain.entity

object SettingsStorage {
    val rowSettingRowModelList = mutableListOf<ItemSettingsRowModel>()
    fun addRowSettingRowModel(item: ItemSettingsRowModel) {
        rowSettingRowModelList.add(item)
    }
}
