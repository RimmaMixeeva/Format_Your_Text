package com.example.formatyourtext.domain.entity

class TextStorage {
    var text = ""
    companion object {
        private val instance = TextStorage()
        fun getInstance(): TextStorage {return instance}
    }
    fun setNewText(item: String) {
        instance.text = item
    }
}