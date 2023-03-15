package com.example.formatyourtext.domain.useCase

import androidx.compose.runtime.Composable
import com.example.formatyourtext.domain.entity.ItemSettingsRowModel
import com.example.formatyourtext.domain.entity.SettingsStorage

fun fillSettingStorage() {
    val storage = SettingsStorage.getInstance()
    storage.addRowSettingRowModel(
        ItemSettingsRowModel(0,
            "Замена дефиса на тире",
            "- Пример",
            "— Пример",
            "-".toRegex(),
            "—"
        ),
    )
    storage.addRowSettingRowModel(
        ItemSettingsRowModel(1,
            "Поставить, если нету, пробелы после . ? ! !? , и убрать лишние",
            "Эй, мера!   Он",
            "Эй,мера! Он",
            "(\\.|\\?|!|!\\?|,) *(\\S)".toRegex(),
            "$1 $2"
        )
    )
    storage.addRowSettingRowModel(ItemSettingsRowModel(2,
        "Поставить, если нету, пробел после тире (—) и убрать лишние",
        "—Пример. —   Да? ",
        "— Пример. — Да?",
        "(—)(\\S)".toRegex(),
        "$1 $2"
    ))
}