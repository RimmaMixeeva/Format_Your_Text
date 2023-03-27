package com.example.formatyourtext.data.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.*

class DataStoreManager(private val context: Context) {

    //to make sure here only one instance
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
    }

    //creates a special name of key for each item
    private fun createSettingKeyName(settingNumber: Int): Preferences.Key<Boolean> {
        return booleanPreferencesKey("KEY_$settingNumber")
    }

    //to set our info
    suspend fun setSetting(settingNumber: Int, isOn: Boolean) {
        context.dataStore.edit { pref ->
            pref[createSettingKeyName(settingNumber)] = isOn
        }
    }

    suspend fun getSetting(settingNumber: Int): Boolean = context.dataStore.data
        .filter { pref ->
            pref.contains(createSettingKeyName(settingNumber))
        }.first()[createSettingKeyName(settingNumber)] ?: false
}

