package com.bluesky.presentation.view.tab.standardcalendar

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

fun NavController.navigateStandardCalendar(navOptions: NavOptions) {
    navigate(StandardCalendarRoute.route, navOptions)
}

fun NavGraphBuilder.standardCalendarNavGraph(
    paddingValues: PaddingValues
) {
    composable(route = StandardCalendarRoute.route) {
        StandardCalendarScreen()
    }
}

object StandardCalendarRoute {
    const val route = "hitMapCalendar"
}
