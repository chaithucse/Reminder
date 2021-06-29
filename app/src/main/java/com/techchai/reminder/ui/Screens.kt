package com.techchai.reminder.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.material.datepicker.MaterialDatePicker

@Composable
fun Home() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "No reminders. Tap " + " to create reminders");
    }
}

@Composable
fun Birthday() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Birthday.", style = MaterialTheme.typography.h4)
    }
}

@Composable
fun Anniversary() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Anniversary.", style = MaterialTheme.typography.h4)
    }
}

@Composable
fun CreateReminder(navController: NavController, activity: AppCompatActivity) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val textState = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = textState.value,
            onValueChange = { newValue -> textState.value = newValue },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text("label") },
            placeholder = { Text("placeholder") },
        )
        Button(onClick = { }) {
            Text(text = "Save")
        }
    }
}

