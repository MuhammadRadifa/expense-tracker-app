package com.example.expensetrackerapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OnBoardingRepository(private val context: Context) {
    companion object{
        private val Context.DataStore: DataStore<Preferences> by preferencesDataStore("isCompletedBoarding")
        val IS_COMPLETED_KEY = booleanPreferencesKey("is_completed_boarding")

        private lateinit var instance: OnBoardingRepository

        fun initialize(context: Context) {
            instance = OnBoardingRepository(context)
        }

        fun getInstance(): OnBoardingRepository {
            if (!::instance.isInitialized) {
                throw UninitializedPropertyAccessException("OnBoardingRepository must be initialized.")
            }
            return instance
        }
    }

    val getCompleted:Flow<Boolean> = context.DataStore.data
        .map {
            preference ->
            preference[IS_COMPLETED_KEY] ?: false
        }

    suspend fun isCompletedBoarding(){
        context.DataStore.edit {
            preference ->
            preference[IS_COMPLETED_KEY] = true
        }
    }
}