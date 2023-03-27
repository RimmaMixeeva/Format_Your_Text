package com.example.formatyourtext.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formatyourtext.domain.entity.ItemSettingsRowModel


@Entity(
    tableName = "SettingsTable",
)
data class Setting(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "setting_name", collate = ColumnInfo.NOCASE) val settingName: String,
    @ColumnInfo(name = "example_before") val exampleBefore: String,
    @ColumnInfo(name = "example_after") val exampleAfter: String,
    @ColumnInfo(name = "regex_before") val regexBefore: String,
    @ColumnInfo(name = "regex_after") val regexAfter: String,
) {
    fun toItemSettingsRowModel(): ItemSettingsRowModel = ItemSettingsRowModel(
        id = id - 1,
        settingName = settingName,
        exampleBefore = exampleBefore,
        exampleAfter = exampleAfter,
        regexBefore = regexBefore.toRegex(),
        regexAfter = regexAfter.toRegex()
    )
}