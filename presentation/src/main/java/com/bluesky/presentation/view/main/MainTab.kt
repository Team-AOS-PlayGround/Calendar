package com.bluesky.presentation.view.main

import com.bluesky.presentation.R
import com.bluesky.presentation.view.tab.hitmapcalendar.HitMapCalendarRoute
import com.bluesky.presentation.view.tab.setting.SettingRoute
import com.bluesky.presentation.view.tab.standardcalendar.StandardCalendarRoute


internal enum class MainTab(
    val iconResId: Int,
    internal val contentDescription: String,
    val route: String,
) {
    STANDARD_CALENDAR(
        iconResId = R.drawable.ic_standard_calendar,
        contentDescription = "홈",
        StandardCalendarRoute.route,
    ),
    HIT_MAP_CALENDAR(
        iconResId = R.drawable.ic_heat_map_caledar,
        contentDescription = "북마크",
        HitMapCalendarRoute.route,
    ),
    SETTING(
        iconResId = R.drawable.ic_setting,
        contentDescription = "설정",
        SettingRoute.route,
    );

    companion object {
        operator fun contains(route: String): Boolean {
            return values().map { it.route }.contains(route)
        }

        fun find(route: String): MainTab? {
            return values().find { it.route == route }
        }
    }
}
