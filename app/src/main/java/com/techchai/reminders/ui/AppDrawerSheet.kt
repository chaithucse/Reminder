package com.techchai.reminders.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.techchai.reminders.navigation.AppNavigations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawerSheet(
    items: List<AppNavigations>,
    currentRoute: String,
    closeDrawer: () -> Unit
) {
    ModalDrawerSheet {
        DrawerHeader()
        items.forEachIndexed { index, destination ->
            NavigationDrawerItem(
                label = { Text(text = destination.title) },
                selected = currentRoute == destination.route,
                onClick = { closeDrawer() },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }
    }
}

@Composable
fun DrawerHeader() {
    Box(modifier = Modifier.height(130.dp)) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "Reminders",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Divider(
            modifier = Modifier.align(Alignment.BottomEnd),
            thickness = 1.dp,
            color = Color.LightGray
        )
    }
}