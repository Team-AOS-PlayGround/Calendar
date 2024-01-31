package com.bluesky.presentation.view.tab.stickycalendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bluesky.composecalendar.compose.VerticalCalendar
import com.bluesky.composecalendar.compose.rememberCalendarState
import com.bluesky.composecalendar.core.CalendarDay
import com.bluesky.composecalendar.core.CalendarMonth
import com.bluesky.composecalendar.core.DayPosition
import com.bluesky.composecalendar.core.daysOfWeek
import com.bluesky.presentation.R
import com.bluesky.presentation.theme.CalendarTheme
import com.bluesky.presentation.theme.Gray900
import com.bluesky.presentation.theme.surfaceDim
import com.bluesky.presentation.view.util.ContinuousSelectionHelper
import com.bluesky.presentation.view.util.DateSelection
import com.bluesky.presentation.view.util.clickable
import com.bluesky.presentation.view.util.displayText

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth

private val continuousSelectionColor = Color.LightGray.copy(alpha = 0.3f)

@Composable
fun StickyCalendarScreen(
    modifier: Modifier,
    dateSelected: DateSelection? = null // 저장된 데이터
) {
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth }
    val endMonth = remember { currentMonth.plusMonths(12) }
    val today = remember { LocalDate.now() }
    var selection by remember {
        if (dateSelected == null)
            mutableStateOf(DateSelection())
        else
            mutableStateOf(dateSelected)
    }
    val daysOfWeek = remember { daysOfWeek() }

    Box(
        modifier = modifier
    ) {
        Column {
            val state = rememberCalendarState(
                startMonth = startMonth,
                endMonth = endMonth,
                firstVisibleMonth = currentMonth,
                firstDayOfWeek = daysOfWeek.first(),
            )
            CalendarTop(
                daysOfWeek = daysOfWeek,
                selection = selection,
            )
            VerticalCalendar(
                state = state,
                contentPadding = PaddingValues(bottom = 100.dp),
                dayContent = { value ->
                    Day(
                        value,
                        today = today,
                        selection = selection,
                    ) { day ->
                        if (day.position == DayPosition.MonthDate &&
                            (day.date == today || day.date.isAfter(today))
                        ) {
                            selection = ContinuousSelectionHelper.getSelection(
                                clickedDate = day.date,
                                dateSelection = selection,
                            )
                        }
                    }
                },
                monthHeader = { month -> MonthHeader(month) },
            )
        }
    }

}

@Composable
private fun Day(
    day: CalendarDay,
    today: LocalDate,
    selection: DateSelection,
    onClick: (CalendarDay) -> Unit,
) {
    var textColor = Color.Transparent
    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clickable(
                enabled = day.position == DayPosition.MonthDate && day.date >= today,
                showRipple = false,
                onClick = { onClick(day) },
            )
            .backgroundHighlight(
                day = day,
                today = today,
                selection = selection,
                selectionColor = Gray900,
                continuousSelectionColor = continuousSelectionColor,
            ) { textColor = it },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = day.date.dayOfMonth.toString(),
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Composable
private fun MonthHeader(calendarMonth: CalendarMonth) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = calendarMonth.yearMonth.displayText(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun CalendarTop(
    modifier: Modifier = Modifier,
    daysOfWeek: List<DayOfWeek>,
    selection: DateSelection,
) {
    Column(modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            val daysBetween = selection.daysBetween
            val text = if (daysBetween == null) {
                stringResource(R.string.sticky_calendar_select_nights)
            } else {
                "$daysBetween" + stringResource(R.string.sticky_calendar_seleted_nights)
            }
            Text(
                modifier = Modifier.padding(14.dp),
                text = text,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
            ) {
                for (dayOfWeek in daysOfWeek) {
                    Text(
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        color = Color.DarkGray,
                        text = dayOfWeek.displayText(),
                        fontSize = 15.sp,
                    )
                }
            }
        }
        Divider()
    }
}

@Composable
@Preview(showBackground = true, widthDp = 400, heightDp = 800)
fun StickyCalendarScreenPreview() {
    CalendarTheme {
        StickyCalendarScreen(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surfaceDim)
        )
    }
}