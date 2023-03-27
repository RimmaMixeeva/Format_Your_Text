package com.example.formatyourtext.data.database.appDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.formatyourtext.data.database.dao.SettingDao
import com.example.formatyourtext.data.database.entities.Setting

@Database(entities = [Setting::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun settingDao(): SettingDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        public fun getDbInstance(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "my_database"
                ).createFromAsset("my_database").build()
                INSTANCE = instance
                return instance
            }


        }

    }
}
