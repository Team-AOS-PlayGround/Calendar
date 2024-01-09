package com.bluesky.data.repository.setting

import com.bluesky.data.datasource.CalendarDataSource
import com.bluesky.domain.model.SelectedDay
import com.bluesky.domain.repository.setting.CalendarRepository
import com.kizitonwose.calendar.core.CalendarDay
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CalendarDataSourceImpl @Inject constructor(
    private val dataSource: CalendarDataSource
) : CalendarRepository {

    override fun getSelectedDays() : Flow<SelectedDay> = dataSource.selectedDay

    override suspend fun updateIsDays(isDays: List<CalendarDay>) {
        dataSource.updateSelectedDays(isDays)
    }

}