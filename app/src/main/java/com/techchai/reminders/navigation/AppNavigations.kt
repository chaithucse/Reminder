package com.techchai.reminders.navigation

import com.techchai.reminders.R

sealed class AppNavigations(val title: String, val icon: Int, val route: String) {
    object All : AppNavigations("All", R.drawable.birth, "all")
    object Birthday : AppNavigations("Birthday", R.drawable.birth, "birthday")
    object Anniversary : AppNavigations("Anniversary", R.drawable.anni_icon, "anniversary")
    object Category : AppNavigations("Category", R.drawable.birth, "category")
    object Greetings : AppNavigations("Greetings", R.drawable.birth, "greetings")
    object Settings : AppNavigations("Settings", R.drawable.birth, "settings")
}

