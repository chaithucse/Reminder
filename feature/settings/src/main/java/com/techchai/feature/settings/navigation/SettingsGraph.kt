package com.techchai.feature.settings.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.techchai.feature.settings.ui.SettingsScreen

const val settingsNavigation = "settings_navigation"

fun NavController.navigateToSettings(navOptions: NavOptions? = null) {
    this.navigate(settingsNavigation, navOptions)
}

fun NavGraphBuilder.settingsNavigation() {
    composable(route = settingsNavigation) {
        SettingsScreen()
    }
}