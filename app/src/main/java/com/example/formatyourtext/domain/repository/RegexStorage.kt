package com.example.formatyourtext.domain.repository

import com.example.formatyourtext.domain.entity.RegexModel

object RegexStorage {
    val RegexModelList = mutableListOf<RegexModel>()
    fun updateRegexModelList(items: ArrayList<RegexModel>) {
        RegexModelList.clear()
        for (each in items) {
            RegexModelList.add(each)
        }
    }
}
