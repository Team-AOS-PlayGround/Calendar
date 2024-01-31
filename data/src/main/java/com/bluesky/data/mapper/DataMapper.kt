package com.bluesky.data.mapper

import com.bluesky.composecalendar.core.CalendarDay
import com.bluesky.domain.model.SelectedDay
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun Set<String>?.deserialize() : List<CalendarDay> {
    return this
        ?.map { it.deserializeFromJson() }
        ?.toList()
        ?: emptyList()
}

fun SelectedDay.serialize(): Set<String>{
    return isDays
        .map { it.serializeToJson() }
        .toSet()
}

private fun CalendarDay.serializeToJson(): String {
    return Json.encodeToString(this)
}

private fun String.deserializeFromJson(): CalendarDay {
    return Json.decodeFromString(this)
}