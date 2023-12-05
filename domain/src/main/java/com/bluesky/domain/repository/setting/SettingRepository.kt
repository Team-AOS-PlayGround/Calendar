package com.bluesky.domain.repository.setting

import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getIsDarkTheme(): Flow<Boolean>

    suspend fun updateIsDarkTheme(isDarkTheme: Boolean)
}