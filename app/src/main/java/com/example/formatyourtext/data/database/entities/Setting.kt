package com.example.formatyourtext.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "SettingsTable"
)
data class Setting (
    @PrimaryKey(autoGenerate = false) val sid: Int,
    @ColumnInfo(name = "setting_name") val settingName: String,
    @ColumnInfo(name = "example_before") val exampleBefore: String,
    @ColumnInfo(name = "example_after") val exampleAfter: String,
    @ColumnInfo(name = "regex_before") val regexBefore: String,
    @ColumnInfo(name = "regex_after") val regexAfter: String,
)