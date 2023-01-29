package com.techchai.feature.taskdetails.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.techchai.feature.taskdetails.TaskDetails

const val detailNavigation = "detail_navigation"

fun NavController.navigateToDetail(navOptions: NavOptions? = null) {
    this.navigate(detailNavigation, navOptions)
}

fun NavGraphBuilder.detailsNavigation() {
    composable(route = detailNavigation) {
        TaskDetails()
    }
}