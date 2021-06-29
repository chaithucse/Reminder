package com.techchai.reminder.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.techchai.reminder.common.AppUtils
import com.techchai.reminder.data.model.Reminder
import com.techchai.reminder.ui.list.ReminderViewModel
import kotlinx.coroutines.launch

@Composable
fun ReminderList(navController: NavController) {
    val fabShape = RoundedCornerShape(50)
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(DrawerValue.Closed)
    )
    val scope = rememberCoroutineScope()
    val reminderViewModel: ReminderViewModel = viewModel()
    val reminderList = reminderViewModel.reminderList.collectAsState().value

    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Reminder",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Cursive,
                        textAlign = TextAlign.Center
                    )
                }

                Column(
                    modifier = Modifier
                ) {
                    Divider()
                    Row(modifier = Modifier
                        .clickable {
                            scope.launch {
                                scaffoldState.drawerState.close()
                                navController.navigate(DrawerScreens.Home.route)
                            }
                        }
                        .fillMaxWidth()
                        .padding(8.dp)
                        .padding(start = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Filled.Home, contentDescription = "")
                        Text(
                            text = "Home",
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Divider()
                    Row(modifier = Modifier
                        .clickable {
                            scope.launch {
                                scaffoldState.drawerState.close()
                                navController.navigate(DrawerScreens.Birthday.route)
                            }
                        }
                        .fillMaxWidth()
                        .padding(8.dp)
                        .padding(start = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Filled.Refresh, contentDescription = "")
                        Text(
                            text = "Birthday",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Divider()
                    Row(modifier = Modifier
                        .clickable {
                            scope.launch {
                                scaffoldState.drawerState.close()
                                navController.navigate(DrawerScreens.Anniversary.route)
                            }
                        }
                        .fillMaxWidth()
                        .padding(8.dp)
                        .padding(start = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Filled.Search, contentDescription = "")
                        Text(
                            text = "Anniversary",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Divider()
                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Reminders")
                },

                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                },

                elevation = AppBarDefaults.TopAppBarElevation
            )
        },

        content = {
            DisplayListView(reminderList)
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(DrawerScreens.CreateReminder.route) },
                shape = fabShape,
                backgroundColor = MaterialTheme.colors.secondary
            ) {
                Icon(Icons.Filled.Add, "")
            }
        },
        isFloatingActionButtonDocked = false,
        floatingActionButtonPosition = FabPosition.End,
    )
}

@Composable
fun DisplayListView(reminders: List<Reminder>) {
    LazyColumn {
        items(reminders) { reminder ->
            ReminderListItem(reminder)
        }
    }
}

//onClick: (Reminder) -> Unit)
@Composable
fun ReminderListItem(item: Reminder) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp, 5.dp, 12.dp, 5.dp)) {
        var expanded by remember { mutableStateOf(false) }
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier
            .padding(5.dp, 5.dp, 5.dp, 5.dp)) {
            Surface(
                modifier = Modifier.size(50.dp),
                shape = CircleShape,
                color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
            ) {
                // Image goes here
            }
            Column(modifier = Modifier
                .padding(start = 8.dp)
                .weight(3f)
                .align(Alignment.CenterVertically)
            ) {
                Text(text = item.name!!, fontWeight = FontWeight.Bold)
                Text(text = AppUtils.convertToDate(item.date!!))
            }
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(alignment = Alignment.CenterVertically)
                    .padding(0.dp, 0.dp, 10.dp, 0.dp),
                text = "Count",
                style = TextStyle(textAlign = TextAlign.End)
            )
        }
    }
}

@Composable
fun EmptyScreen(
    @StringRes titleId: Int,
    @StringRes subTitleId: Int
) {
    Box(
        modifier = Modifier.fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 64.dp)) {
            Text(
                text = stringResource(titleId),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colors.onSurface,
                style = TextStyle(/*
 fontSize = TextUnit.dp(18),*/
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = stringResource(subTitleId),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                color = MaterialTheme.colors.onSurface,
                style = TextStyle(/*
 fontSize = TextUnitType.Sp(16),*/
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}