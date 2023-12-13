package com.bluesky.presentation.view.tab.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.bluesky.presentation.theme.CalendarTheme

@Composable
internal fun SettingScreen(
) {
    Column(
        Modifier.background(Color.Gray)
    ) {

    }
}


@Composable
@Preview(showBackground = true, widthDp = 400, heightDp = 800)
fun SettingScreenPreview() {
    CalendarTheme {
        SettingScreen()
    }
}