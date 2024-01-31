package com.bluesky.domain.repository.setting

import com.bluesky.composecalendar.core.CalendarDay
import com.bluesky.domain.model.SelectedDay
import kotlinx.coroutines.flow.Flow

interface CalendarRepository {
    fun getSelectedDays(): Flow<SelectedDay>

    suspend fun updateIsDays(isDays: List<CalendarDay>)
}