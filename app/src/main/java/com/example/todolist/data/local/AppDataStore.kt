package com.example.todolist.data.local

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

private val Context.dataStore by preferencesDataStore(name = "app_prefs")

class AppDataStore(private val context: Context) {

    private val FIRST_RUN_KEY = booleanPreferencesKey("is_first_run")

    suspend fun isFirstaRun(): Boolean{
        val prefs = context.dataStore.data.first()
        return prefs[FIRST_RUN_KEY] != false
    }

    suspend fun setFirstRunDone(){
        context.dataStore.edit{
            prefs -> prefs[FIRST_RUN_KEY] = false
        }
    }

}
