package com.bluesky.presentation.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluesky.domain.usecase.calendar.GetCalendarUseCase
import com.bluesky.domain.usecase.setting.GetSettingUseCase
import com.kizitonwose.calendar.core.CalendarDay
//import com.bluesky.domain.usecase.setting.GetSettingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSettingUseCase: GetSettingUseCase,
    private val getCalendarUseCase: GetCalendarUseCase
) : ViewModel() {
    val isDarkTheme = getSettingUseCase.getIsDarkTheme()
    val isSelectedDays = getCalendarUseCase.getSelectedDays()

    fun updateIsDarkTheme(isDarkTheme: Boolean) = viewModelScope.launch {
        getSettingUseCase.updateIsDarkTheme(isDarkTheme)
    }

    fun updateIsSelectedDays(isSelectedDays: List<CalendarDay>) = viewModelScope.launch {
        getCalendarUseCase.updateIsDays(isSelectedDays)
    }
}