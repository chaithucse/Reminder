package com.techchai.feature.settings.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text("Settings")
            })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            SettingsContent()
        }
    }
}

@Composable
fun SettingsContent() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        val (title, description) = createRefs()

    }
}