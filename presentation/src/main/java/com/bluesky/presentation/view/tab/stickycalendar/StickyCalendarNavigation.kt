package com.bluesky.presentation.view.tab.stickycalendar


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable


fun NavController.navigateStickyCalendar(navOptions: NavOptions) {
    navigate(StickyCalendarRoute.route, navOptions)
}

fun NavGraphBuilder.stickyCalendarNavGraph(
    modifier: Modifier,
    paddingValues: PaddingValues
) {
    composable(route = StickyCalendarRoute.route) {
        StickyCalendarScreen(modifier)
    }
}

object StickyCalendarRoute {
    const val route = "StickyCalendar"
}