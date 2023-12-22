package com.bluesky.presentation.view.tab.hitmapcalendar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

fun NavController.navigateHitMapCalendar(navOptions: NavOptions) {
    navigate(HitMapCalendarRoute.route, navOptions)
}

fun NavGraphBuilder.hitMapCalendarNavGraph(
    modifier: Modifier,
    paddingValues: PaddingValues
) {
    composable(route = HitMapCalendarRoute.route) {
        HitMapCalendarScreen(modifier)
    }
}

object HitMapCalendarRoute {
    const val route = "hitMapCalendar"
}
