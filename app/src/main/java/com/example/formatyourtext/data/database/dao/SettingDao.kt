package com.example.formatyourtext.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.formatyourtext.data.database.entities.Setting

@Dao
interface SettingDao {
    @Query("SELECT * FROM SettingsTable")
    fun getAll(): LiveData<List<Setting>>
}
