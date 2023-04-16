package com.example.formatyourtext.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "RegexToSettingTable",
    primaryKeys = ["setting_id", "regex_id"],
    foreignKeys = [
        ForeignKey(
            entity = Setting::class,
            parentColumns = ["id"],
            childColumns = ["setting_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AppRegex::class,
            parentColumns = ["id"],
            childColumns = ["regex_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class RegexToSetting(
    @ColumnInfo(name = "setting_id") val settingId: Int,
    @ColumnInfo(name = "regex_id") val regexId: Int,
)
