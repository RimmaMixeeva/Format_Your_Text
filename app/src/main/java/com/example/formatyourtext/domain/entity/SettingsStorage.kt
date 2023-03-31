package com.example.formatyourtext.domain.entity

object SettingsStorage {
    val rowSettingRowModelList = mutableListOf<ItemSettingsRowModel>()
    fun updateRowSettingRowModels(items: ArrayList<ItemSettingsRowModel>) {
        rowSettingRowModelList.clear()
        for (each in items) {
            rowSettingRowModelList.add(each)
        }

    }
}
