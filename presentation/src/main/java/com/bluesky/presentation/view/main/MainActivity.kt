package com.bluesky.presentation.view.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalendarApp()
            /*val navigator: MainNavigator = rememberMainNavigator()

            CalendarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp(
                        navigator = navigator,
                        onChangeDarkTheme = { isDarkTheme -> viewModel.updateIsDarkTheme(isDarkTheme) }
                    )
                }
            }*/
        }
    }
}