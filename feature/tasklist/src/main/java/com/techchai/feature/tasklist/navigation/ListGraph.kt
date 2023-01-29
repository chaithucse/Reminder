package com.techchai.feature.tasklist.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.techchai.feature.tasklist.ui.TaskListRoute

const val listNavigationRoute = "list_route"

fun NavController.navigateToList(navOptions: NavOptions? = null) {
    this.navigate(listNavigationRoute, navOptions)
}

fun NavGraphBuilder.listNavigation(openDrawer: () -> Unit, onNavigateToCreate: () -> Unit) {
    composable(route = listNavigationRoute) {
        TaskListRoute(openDrawer, onNavigateToCreate)
    }
}