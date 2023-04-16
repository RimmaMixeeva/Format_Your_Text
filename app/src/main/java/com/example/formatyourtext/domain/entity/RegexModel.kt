package com.example.formatyourtext.domain.entity

data class RegexModel(
    val id: Int,
    val regexName: String,
    val regexBefore: String,
    val regexAfter: String,
    val ignoreCase: Int,
    val priority: Int,
    val settingId: Int
)
