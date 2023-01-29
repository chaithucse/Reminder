package com.techchai.reminders.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.techchai.feature.settings.navigation.settingsNavigation
import com.techchai.feature.taskcreate.navigation.createNavigation
import com.techchai.feature.taskcreate.navigation.navigateToCreate
import com.techchai.feature.tasklist.navigation.listNavigation
import com.techchai.feature.tasklist.navigation.listNavigationRoute

@Composable
fun AppNavGraph(
    navController: NavHostController,
    startDestination: String = listNavigationRoute,
    openDrawer: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        listNavigation(
            openDrawer = { openDrawer() },
            onNavigateToCreate = { navController.navigateToCreate() }
        )
        createNavigation(navController)
        settingsNavigation()
    }
}