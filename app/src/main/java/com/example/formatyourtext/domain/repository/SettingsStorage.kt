package com.example.formatyourtext.domain.repository

import com.example.formatyourtext.domain.entity.ItemSettingsRowModel

object SettingsStorage {
    val rowSettingRowModelList = mutableListOf<ItemSettingsRowModel>()
    fun updateRowSettingRowModels(items: ArrayList<ItemSettingsRowModel>) {
        rowSettingRowModelList.clear()
        for (each in items) {
            rowSettingRowModelList.add(each)
        }
    }
}
