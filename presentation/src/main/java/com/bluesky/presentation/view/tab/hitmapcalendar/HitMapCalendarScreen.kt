package com.bluesky.presentation.view.tab.hitmapcalendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bluesky.presentation.theme.CalendarTheme
import com.bluesky.presentation.view.tab.setting.SettingScreen

@Composable
internal fun HitMapCalendarScreen() {
    Column(
        Modifier.fillMaxSize().background(Color.Blue)
    ) {

    }
}


@Composable
@Preview(showBackground = true, widthDp = 400, heightDp = 800)
fun HitMapCalendarScreenPreview() {
    CalendarTheme {
        HitMapCalendarScreen()
    }
}