package com.bluesky.domain.usecase.setting

import com.bluesky.domain.repository.setting.SettingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * 저장해 둔 테마 모드를 가져 온다.
 */
class GetSettingUseCase @Inject constructor(private val repository: SettingRepository) {
    fun getIsDarkTheme(): Flow<Boolean> = repository.getIsDarkTheme()

    suspend fun updateIsDarkTheme(isDarkTheme: Boolean) = repository.updateIsDarkTheme(isDarkTheme)
}