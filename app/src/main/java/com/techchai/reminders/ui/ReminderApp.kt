@file:OptIn(ExperimentalMaterial3Api::class)

package com.techchai.reminders.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.techchai.reminders.navigation.AppNavGraph
import com.techchai.reminders.navigation.AppNavigations
import kotlinx.coroutines.launch

@Composable
fun ReminderApp() {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    //drawer list
    val items = listOf(
        AppNavigations.All,
        AppNavigations.Birthday,
        AppNavigations.Anniversary,
        AppNavigations.Category,
        AppNavigations.Greetings,
        AppNavigations.Settings
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: AppNavigations.All.route

    ModalNavigationDrawer(
        drawerContent = {
            AppDrawerSheet(items, currentRoute, closeDrawer = {
                scope.launch { drawerState.close() }
            })
        },
        drawerState = drawerState,
    ) {
        AppNavGraph(navController, openDrawer = {
            scope.launch { drawerState.open() }
        })
    }
}

@Composable
fun BottomComponent() {
    val navController = rememberNavController()

    val items = listOf(
        AppNavigations.All,
        AppNavigations.Birthday,
        AppNavigations.Category,
        AppNavigations.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: AppNavigations.All.route
/*
    NavigationBar {
        items.forEach {
            NavigationBarItem(selected = , onClick = { *//*TODO*//* }, icon = {

            })
        }
    }*/
}