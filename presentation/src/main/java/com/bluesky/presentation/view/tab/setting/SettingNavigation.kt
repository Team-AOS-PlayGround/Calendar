package com.bluesky.presentation.view.tab.setting

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

fun NavController.navigateSetting(navOptions: NavOptions) {
    navigate(SettingRoute.route, navOptions)
}

fun NavGraphBuilder.settingNavGraph(
    paddingValues: PaddingValues
) {
    composable(route = SettingRoute.route) {
        SettingScreen()
    }
}

object SettingRoute {
    const val route = "setting"
}
