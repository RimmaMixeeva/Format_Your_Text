package com.example.formatyourtext.domain.entity

object SettingsStorage {
    val rowSettingRowModelList = mutableListOf<ItemSettingsRowModel>()
    fun addRowSettingRowModels(items: ArrayList<ItemSettingsRowModel>) {
        if (rowSettingRowModelList.size==0) {
            for (each in items) {
                rowSettingRowModelList.add(each)
            }
        }

    }
}
