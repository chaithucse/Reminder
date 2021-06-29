package com.techchai.reminder.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.techchai.reminder.R
import com.techchai.reminder.ui.theme.ReminderTheme

sealed class DrawerScreens(val title: String, val route: String) {
    object Home : DrawerScreens("Reminders", "home")
    object Birthday : DrawerScreens("Birthday Reminders", "birthday")
    object Anniversary : DrawerScreens( "Anniversary Reminders", "anniversary")
    object CreateReminder : DrawerScreens( "Create Reminder", "create")
}
/*

private val screens = listOf(
    DrawerScreens.Home,
    DrawerScreens.Birthday,
    DrawerScreens.Anniversary
)

@Composable
fun Drawer(
    modifier: Modifier = Modifier,
    onDestinationClicked: (route: String) -> Unit
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(start = 24.dp, top = 48.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "App icon"
        )
        screens.forEach { screen ->
            Spacer(Modifier.height(19.dp))
            Text(
                text = screen.title,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.clickable {
                    onDestinationClicked(screen.route)
                }
            )
        }
    }
}

@Preview
@Composable
fun DrawerPreview() {
    ReminderTheme() {
        Drawer{}
    }
*/