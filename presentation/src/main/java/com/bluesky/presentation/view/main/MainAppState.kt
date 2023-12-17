package com.bluesky.presentation.view.main

import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import androidx.compose.material3.SnackbarHostState
import kotlinx.coroutines.launch

object CalendarDestinations {

}

@Composable
fun rememberCalendarAppState(
    snackBarHostState: SnackbarHostState = SnackbarHostState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
) =
    remember(snackBarHostState, navController,resources,coroutineScope){
        CalendarAppState(
            snackBarHostState = snackBarHostState,
            navController = navController,
            resources = resources,
            coroutineScope = coroutineScope
        )
}

@Stable
class CalendarAppState(
    val  snackBarHostState: SnackbarHostState,
    val navController: NavHostController,
    private val resources: Resources,
    val coroutineScope: CoroutineScope
){
    init {
        coroutineScope.launch {

        }
    }

//    val bottomBarTabs =  CalendarSections.values()
}

@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}