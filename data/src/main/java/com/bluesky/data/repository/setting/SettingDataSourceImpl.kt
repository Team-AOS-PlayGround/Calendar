package com.bluesky.data.repository.setting

import com.bluesky.data.datasource.SettingDataSource
import com.bluesky.domain.repository.setting.SettingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingDataSourceImpl @Inject constructor(
    private val dataSource: SettingDataSource
) : SettingRepository {
    override fun getIsDarkTheme(): Flow<Boolean> =
        dataSource.settingsData.map { settingsData -> settingsData.isDarkTheme }

    override suspend fun updateIsDarkTheme(isDarkTheme: Boolean) {
        dataSource.updateIsDarkTheme(isDarkTheme)
    }
}