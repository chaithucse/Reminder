package com.techchai.reminder.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ReminderApp(activity: AppCompatActivity) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = DrawerScreens.Home.route
    ) {
        composable(DrawerScreens.Home.route) {
            ReminderList(navController)
        }
        composable(DrawerScreens.Birthday.route) {
            Birthday()
        }
        composable(DrawerScreens.Anniversary.route) {
            Anniversary()
        }
        composable(DrawerScreens.CreateReminder.route) {
            ReminderAdd(navController, activity)
        }
    }
}