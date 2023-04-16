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
) {
    fun toItemSettingsRowModel(): ItemSettingsRowModel = ItemSettingsRowModel(
        id = this.id - 1,
        settingName = this.settingName,
        exampleBefore = this.exampleBefore,
        exampleAfter = this.exampleAfter
    )
}