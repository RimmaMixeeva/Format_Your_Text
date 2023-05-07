package com.example.formatyourtext.domain.entity

data class ItemSettingsRowModel (
    val id: Int,
    val settingName: String,
    val exampleBefore: String,
    val exampleAfter: String,
    val isOn: Int
    )
