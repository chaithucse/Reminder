package com.techchai.feature.tasklist.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.techchai.core.database.model.Reminder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListItem(reminder: Reminder) {
    Log.d("CHAIT", "Reminder: ${reminder.title}")
    Card(
        onClick = { /*TODO*/ }, modifier = Modifier
            .wrapContentHeight()
            .padding(start = 12.dp, end = 12.dp, top = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Person, "")
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                reminder.title?.let { Text(text = it) }
                Text(text = "Description")
                Row {
                    Text(text = "Nov 15th")
                    Text(text = "10.00 AM")
                }
            }
            IconButton(modifier = Modifier, onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Face, "")
            }
        }
    }
}
