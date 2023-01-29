@file:OptIn(ExperimentalMaterial3Api::class)

package com.techchai.feature.tasklist.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun TaskListRoute(openDrawer: () -> Unit, onNavigateToCreate: () -> Unit) {
    TaskList(openDrawer, onNavigateToCreate)
}

@OptIn(ExperimentalLifecycleComposeApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun TaskList(openDrawer: () -> Unit, onNavigateToCreate: () -> Unit) {

    val viewModel: TaskListViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val listState = rememberLazyListState()

    when(uiState) {
        is TaskListUiState.Loading -> {}
        is TaskListUiState.Success -> {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = { Text("Reminders") },
                        navigationIcon = {
                            IconButton(onClick = { openDrawer() }) {
                                Icon(Icons.Filled.Menu, "")
                            }
                        })
                },
                floatingActionButton = {
                    ExtendedFloatingActionButton(
                        icon = { Icon(Icons.Filled.Create, "create") },
                        text = { Text(text = "Create") },
                        expanded = listState.isScrollingUp(),
                        onClick = { onNavigateToCreate() }
                    )
                }
            ) { contentPadding ->
                Box(
                    modifier = Modifier
                        .padding(contentPadding)
                        .fillMaxWidth()
                ) {
                    LazyColumn(state = listState, modifier = Modifier.fillMaxSize()) {
                        items((uiState as TaskListUiState.Success).data) { item ->
                            TaskListItem(item)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun LazyListState.isScrollingUp(): Boolean {
    var previousIndex by remember(this) { mutableStateOf(firstVisibleItemIndex) }
    var previousScrollOffset by remember(this) { mutableStateOf(firstVisibleItemScrollOffset) }
    return remember(this) {
        derivedStateOf {
            if (previousIndex != firstVisibleItemIndex) {
                previousIndex > firstVisibleItemIndex
            } else {
                previousScrollOffset >= firstVisibleItemScrollOffset
            }.also {
                previousIndex = firstVisibleItemIndex
                previousScrollOffset = firstVisibleItemScrollOffset
            }
        }
    }.value
}