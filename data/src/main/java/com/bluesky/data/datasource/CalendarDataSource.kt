package com.bluesky.data.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.bluesky.data.mapper.deserialize
import com.bluesky.data.mapper.serialize
import com.bluesky.domain.model.SelectedDay
import com.kizitonwose.calendar.core.CalendarDay
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Named

class CalendarDataSource @Inject constructor(
    @Named("calendar") private val dataStore: DataStore<Preferences>
) {
    object PreferencesKey {
        val SELECTED_DAYS = stringSetPreferencesKey("SELECTED_DAYS_STANDARD")
    }

    val selectedDay = dataStore.data.map { preferences ->
        SelectedDay(
            isDays = preferences[PreferencesKey.SELECTED_DAYS].deserialize()
        )
    }

    suspend fun updateSelectedDays(isDays: List<CalendarDay>) {
        dataStore.edit { preferences ->
            val selectedDays = SelectedDay(isDays)
            preferences[PreferencesKey.SELECTED_DAYS] = selectedDays.serialize()
        }
    }
}
