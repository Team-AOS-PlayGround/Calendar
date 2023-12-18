package com.bluesky.presentation.view.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.bluesky.presentation.view.tab.hitmapcalendar.navigateHitMapCalendar
import com.bluesky.presentation.view.tab.setting.navigateSetting
import com.bluesky.presentation.view.tab.standardcalendar.StandardCalendarRoute
import com.bluesky.presentation.view.tab.standardcalendar.navigateStandardCalendar

internal class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination = MainTab.STANDARD_CALENDAR.route

    val currentTab: MainTab?
        @Composable get() = currentDestination
            ?.route
            ?.let(MainTab::find)

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when (tab) {
            MainTab.STANDARD_CALENDAR -> navController.navigateStandardCalendar(navOptions)
            MainTab.HIT_MAP_CALENDAR -> navController.navigateHitMapCalendar(navOptions)
            MainTab.SETTING -> navController.navigateSetting(navOptions)
        }
    }
    @Composable
    fun shouldShowBottomBar(): Boolean {
        val currentRoute = currentDestination?.route ?: return false
        return currentRoute in MainTab
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}
