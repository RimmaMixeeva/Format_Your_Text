package com.example.formatyourtext.domain.useCase

import com.example.formatyourtext.domain.entity.ItemSettingsRowModel
import com.example.formatyourtext.domain.entity.SettingsStorage

fun fillSettingStorage() {
    var array = ArrayList<ItemSettingsRowModel>()
    array.add(ItemSettingsRowModel(0,
        "Замена дефиса на тире",
        "- Пример",
        "— Пример",
        "-".toRegex(),
        "—"
    ))
    array.add(ItemSettingsRowModel(1,
        "Поставить, если нету, пробелы после . ? ! !? , и убрать лишние",
        "Эй, мера!   Он",
        "Эй,мера! Он",
        "(\\.|\\?|!|!\\?|,) *(\\S)".toRegex(),
        "$1 $2"
    ))
    array.add(ItemSettingsRowModel(2,
        "Поставить, если нету, пробел после тире (—) и убрать лишние",
        "—Пример. —   Да? ",
        "— Пример. — Да?",
        "(—)(\\S)".toRegex(),
        "$1 $2"
    ))

    SettingsStorage.addRowSettingRowModels(array)
}