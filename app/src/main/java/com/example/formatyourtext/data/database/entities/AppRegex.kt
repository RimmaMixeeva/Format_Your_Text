package com.example.formatyourtext.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.formatyourtext.domain.entity.RegexModel


@Entity(
    tableName = "RegexTable",
)
data class AppRegex(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "regex_name", collate = ColumnInfo.NOCASE) val regexName: String,
    @ColumnInfo(name = "regex_before") val regexBefore: String,
    @ColumnInfo(name = "regex_after") val regexAfter: String,
    @ColumnInfo(name = "ignore_case") val ignoreCase: Boolean,
    @ColumnInfo(name = "priority") val priority: Int,
) {
    fun toRegexModel(): RegexModel = RegexModel(
        id = this.id - 1,
        regexName = this.regexName,
        regexBefore = this.regexBefore,
        regexAfter = this.regexAfter,
        ignoreCase = this.ignoreCase,
        priority = this.priority
    )
}
