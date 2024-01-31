package com.bluesky.domain.usecase.calendar

import com.bluesky.composecalendar.core.CalendarDay
import com.bluesky.domain.model.SelectedDay
import com.bluesky.domain.repository.setting.CalendarRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCalendarUseCase @Inject constructor(private val repository: CalendarRepository) {
    fun getSelectedDays(): Flow<SelectedDay> = repository.getSelectedDays()

    suspend fun updateIsDays(isSelectedDays: List<CalendarDay>) = repository.updateIsDays(isSelectedDays)
}