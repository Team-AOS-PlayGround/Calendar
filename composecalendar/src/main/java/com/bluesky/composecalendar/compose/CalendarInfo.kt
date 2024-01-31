package com.bluesky.composecalendar.compose

import com.bluesky.composecalendar.core.OutDateStyle
import java.time.DayOfWeek

internal data class CalendarInfo(
    val indexCount: Int,
    private val firstDayOfWeek: DayOfWeek? = null,
    private val outDateStyle: OutDateStyle? = null,
)
