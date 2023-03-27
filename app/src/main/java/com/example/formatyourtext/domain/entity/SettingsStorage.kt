package com.example.formatyourtext.domain.entity

object SettingsStorage {
    val rowSettingRowModelList = mutableListOf<ItemSettingsRowModel>()
    fun addRowSettingRowModels(items: ArrayList<ItemSettingsRowModel>) {
        for (each in items) {
            rowSettingRowModelList.add(each)
        }

    }
}
