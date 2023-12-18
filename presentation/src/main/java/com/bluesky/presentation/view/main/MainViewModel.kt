package com.bluesky.presentation.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.bluesky.domain.usecase.setting.GetSettingUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
//    private val getSettingUseCase: GetSettingUseCase
) : ViewModel() {
   /* val isDarkTheme = getSettingUseCase.getIsDarkTheme()

    fun updateIsDarkTheme(isDarkTheme: Boolean) = viewModelScope.launch {
        getSettingUseCase.updateIsDarkTheme(isDarkTheme)
    }*/
}