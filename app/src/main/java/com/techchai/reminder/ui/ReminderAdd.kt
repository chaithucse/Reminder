package com.techchai.reminder.ui

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.MaterialTimePicker.INPUT_MODE_CLOCK
import com.google.android.material.timepicker.TimeFormat
import com.techchai.reminder.common.AppUtils
import com.techchai.reminder.ui.create.CreateReminderViewModel

@Composable
fun ReminderAdd(navController: NavController, activity: AppCompatActivity) {
    val viewModel: CreateReminderViewModel = viewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Create Reminder")
                },

                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "")
                    }
                },

                elevation = AppBarDefaults.TopAppBarElevation
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val textState = remember { mutableStateOf(TextFieldValue()) }
                val date: String by viewModel.createDate.observeAsState("")
                val time: String by viewModel.createTime.observeAsState("")

                Column() {
                    Text(
                        text = "Choose Reminder category",
                        modifier = Modifier.padding(16.dp, 12.dp, 16.dp, 0.dp)
                    )
                    CreateChips(viewModel)
                    OutlinedTextField(
                        value = textState.value,
                        onValueChange = { newValue ->
                            textState.value = newValue
                            viewModel.setReminderName(newValue.text)
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        label = { Text("Name") },
                        placeholder = { Text("placeholder") },
                    )

                    Row() {
                        OutlinedTextField(
                            value = date,
                            enabled = false,
                            onValueChange = { },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .clickable { showDatePicker(viewModel, activity) },
                            label = { Text("Date") },
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = time,
                            enabled = false,
                            onValueChange = { },
                            modifier = Modifier
                                .padding(8.dp)
                                .weight(1f)
                                .clickable { showTimePicker(viewModel, activity) },
                            label = { Text("Time") },
                            singleLine = true
                        )

                    }
                }

                Spacer(modifier = Modifier.padding(16.dp))
                Button(
                    onClick = {
                        viewModel.saveReminder()
                        navController.popBackStack()
                    },
                    modifier = Modifier.padding(16.dp),
                    elevation = ButtonDefaults.elevation()
                ) {
                    Text(text = "Save", modifier = Modifier.padding(10.dp, 3.dp, 10.dp, 3.dp))
                }
            }
        }
    )
}

fun showDatePicker(viewModel: CreateReminderViewModel, activity: AppCompatActivity) {
    val picker = MaterialDatePicker.Builder.datePicker().build()
    activity?.let {
        picker.show(it.supportFragmentManager, picker.toString())
        picker.addOnPositiveButtonClickListener {
            viewModel.setReminderDate(AppUtils.convertToDate(picker.selection.toString()))
            picker.dismiss()
        }
    }
}

fun showTimePicker(viewModel: CreateReminderViewModel, activity: AppCompatActivity) {
    val picker = MaterialTimePicker.Builder().setTimeFormat(TimeFormat.CLOCK_24H)
        .setInputMode(INPUT_MODE_CLOCK).build()
    activity?.let {
        picker.show(it.supportFragmentManager, picker.toString())
        picker.addOnPositiveButtonClickListener {
            viewModel.setReminderTime(picker.hour.toString() + ":" + picker.minute.toString() + " " + picker.inputMode.toString())
            picker.dismiss()
        }
    }
}

@Composable
fun CreateChips(viewModel: CreateReminderViewModel) {
    val radioOptions = listOf("General", "Birthday", "Anniversary")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Row(Modifier.selectableGroup()) {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            viewModel.setCategory(text)
                            onOptionSelected(text)
                        },
                        role = Role.RadioButton
                    )
                    .padding(12.dp, 8.dp, 16.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null // null recommended for accessibility with screenreaders
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}