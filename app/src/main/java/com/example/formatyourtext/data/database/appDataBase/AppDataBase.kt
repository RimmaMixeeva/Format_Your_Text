package com.example.formatyourtext.data.database.appDataBase

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.formatyourtext.data.database.dao.SettingDao
import com.example.formatyourtext.data.database.entities.AppRegex
import com.example.formatyourtext.data.database.entities.Setting

@Database(entities = [Setting::class, AppRegex::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun settingDao(): SettingDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDbInstance(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null)    {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "our_database"
                )
                    .createFromAsset("our_database")
                    .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }}


        }
    }

