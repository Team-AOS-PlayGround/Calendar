package com.bluesky.presentation.view.tab.stickycalendar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.bluesky.composecalendar.core.CalendarDay
import com.bluesky.composecalendar.core.DayPosition
import com.bluesky.presentation.theme.Gray300
import com.bluesky.presentation.theme.Gray900
import com.bluesky.presentation.theme.Orange200
import com.bluesky.presentation.view.util.ContinuousSelectionHelper.isInDateBetweenSelection
import com.bluesky.presentation.view.util.ContinuousSelectionHelper.isOutDateBetweenSelection
import com.bluesky.presentation.view.util.DateSelection

import java.time.LocalDate

private class HalfSizeShape(private val clipStart: Boolean) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density,
    ): Outline {
        val half = size.width / 2f
        val offset = if (layoutDirection == LayoutDirection.Ltr) {
            if (clipStart) Offset(half, 0f) else Offset.Zero
        } else {
            if (clipStart) Offset.Zero else Offset(half, 0f)
        }
        return Outline.Rectangle(Rect(offset, Size(half, size.height)))
    }
}

/**
 * Modern Airbnb highlight style, as seen in the app.
 * See also [backgroundHighlightLegacy].
 */
fun Modifier.backgroundHighlight(
    day: CalendarDay,
    today: LocalDate,
    selection: DateSelection,
    selectionColor: Color,
    continuousSelectionColor: Color,
    textColor: (Color) -> Unit,
): Modifier = composed {
    val (startDate, endDate) = selection
    val padding = 4.dp
    when (day.position) {
        DayPosition.MonthDate -> {
            when {
                day.date.isBefore(today) -> {
                    textColor(Gray300)
                    this
                }
                startDate == day.date && endDate == null -> {
                    textColor(Color.White)
                    padding(padding)
                        .background(color = selectionColor, shape = CircleShape)
                }
                day.date == startDate -> {
                    textColor(Color.White)
                    padding(vertical = padding)
                        .background(
                            color = continuousSelectionColor,
                            shape = HalfSizeShape(clipStart = true),
                        )
                        .padding(horizontal = padding)
                        .background(color = selectionColor, shape = CircleShape)
                }
                startDate != null && endDate != null && (day.date > startDate && day.date < endDate) -> {
                    textColor(Gray900)
                    padding(vertical = padding)
                        .background(color = continuousSelectionColor)
                }
                day.date == endDate -> {
                    textColor(Color.White)
                    padding(vertical = padding)
                        .background(
                            color = continuousSelectionColor,
                            shape = HalfSizeShape(clipStart = false),
                        )
                        .padding(horizontal = padding)
                        .background(color = selectionColor, shape = CircleShape)
                }
                day.date == today -> {
                    textColor(Gray900)
                    padding(padding)
                        .border(
                            width = 1.dp,
                            shape = CircleShape,
                            color = Orange200,
                        )
                }
                else -> {
                    textColor(Gray900)
                    this
                }
            }
        }
        DayPosition.InDate -> {
            textColor(Color.Transparent)
            if (startDate != null && endDate != null &&
                isInDateBetweenSelection(day.date, startDate, endDate)
            ) {
                padding(vertical = padding)
                    .background(color = continuousSelectionColor)
            } else this
        }
        DayPosition.OutDate -> {
            textColor(Color.Transparent)
            if (startDate != null && endDate != null &&
                isOutDateBetweenSelection(day.date, startDate, endDate)
            ) {
                padding(vertical = padding)
                    .background(color = continuousSelectionColor)
            } else this
        }
    }
}

/**
 * Old Airbnb highlight style.
 * See also [backgroundHighlight].
 */
fun Modifier.backgroundHighlightLegacy(
    day: CalendarDay,
    today: LocalDate,
    selection: DateSelection,
    selectionColor: Color,
    textColor: (Color) -> Unit,
): Modifier = composed {
    val (startDate, endDate) = selection
    val padding = 4.dp
    when (day.position) {
        DayPosition.MonthDate -> {
            when {
                day.date.isBefore(today) -> {
                    textColor(Gray300)
                    this
                }
                startDate == day.date && endDate == null -> {
                    textColor(Color.White)
                    padding(padding)
                        .background(color = selectionColor, shape = CircleShape)
                }
                day.date == startDate -> {
                    textColor(Color.White)
                    padding(vertical = padding)
                        .background(
                            color = selectionColor,
                            shape = RoundedCornerShape(
                                topStartPercent = 50,
                                bottomStartPercent = 50,
                            ),
                        )
                }
                startDate != null && endDate != null && (day.date > startDate && day.date < endDate) -> {
                    textColor(Color.White)
                    padding(vertical = padding)
                        .background(color = selectionColor)
                }
                day.date == endDate -> {
                    textColor(Color.White)
                    padding(vertical = padding)
                        .background(
                            color = selectionColor,
                            shape = RoundedCornerShape(topEndPercent = 50, bottomEndPercent = 50),
                        )
                }
                day.date == today -> {
                    textColor(Gray300)
                    padding(padding)
                        .border(
                            width = 1.dp,
                            shape = CircleShape,
                            color = Gray300,
                        )
                }
                else -> {
                    textColor(Gray300)
                    this
                }
            }
        }
        DayPosition.InDate -> {
            textColor(Color.Transparent)
            if (startDate != null && endDate != null &&
                isInDateBetweenSelection(day.date, startDate, endDate)
            ) {
                padding(vertical = padding)
                    .background(color = selectionColor)
            } else this
        }
        DayPosition.OutDate -> {
            textColor(Color.Transparent)
            if (startDate != null && endDate != null &&
                isOutDateBetweenSelection(day.date, startDate, endDate)
            ) {
                padding(vertical = padding)
                    .background(color = selectionColor)
            } else this
        }
    }
}
