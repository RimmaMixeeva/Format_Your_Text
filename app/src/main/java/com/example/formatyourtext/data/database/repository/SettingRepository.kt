package com.example.formatyourtext.data.database.repository

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.formatyourtext.data.database.dao.SettingDao
import com.example.formatyourtext.data.database.entities.AppRegex
import com.example.formatyourtext.data.database.entities.Setting

class SettingRepository(private val settingDao: SettingDao) {

    val readAllData: LiveData<List<Setting>> = settingDao.getAll()

    val readAllRegex: LiveData<List<AppRegex>> = settingDao.getAllRegex()

}