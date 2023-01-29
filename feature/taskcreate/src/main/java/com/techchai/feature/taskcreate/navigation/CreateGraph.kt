package com.techchai.feature.taskcreate.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.techchai.feature.taskcreate.TaskCreateRoute

const val createNavigation = "create_navigation"

fun NavController.navigateToCreate(navOptions: NavOptions? = null) {
    this.navigate(createNavigation, navOptions)
}

fun NavGraphBuilder.createNavigation(navController: NavController) {

    composable(route = createNavigation) {
        TaskCreateRoute(onCancelClick = {
            navController.popBackStack()
        }, onSubmitClick = {
            navController.popBackStack()
        })
    }
}