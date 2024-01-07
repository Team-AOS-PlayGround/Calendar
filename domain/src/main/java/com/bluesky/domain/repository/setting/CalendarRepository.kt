package com.bluesky.domain.repository.setting

import com.bluesky.data.model.SelectedDay
import com.kizitonwose.calendar.core.CalendarDay
import kotlinx.coroutines.flow.Flow

interface CalendarRepository {
    fun getSelectedDays(): Flow<SelectedDay>

    suspend fun updateIsDays(isDays: List<CalendarDay>)
}