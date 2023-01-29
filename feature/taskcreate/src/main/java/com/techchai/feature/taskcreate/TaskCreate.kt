@file:OptIn(ExperimentalMaterial3Api::class)

package com.techchai.feature.taskcreate

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddTask
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.techchai.core.database.model.Reminder
import java.util.*

@Composable
fun TaskCreateRoute(onCancelClick: () -> Unit, onSubmitClick: () -> Unit) {
    val viewModel: TaskCreateViewModel = hiltViewModel()

    TaskCreateScreen(
        viewModel = viewModel,
        onCancelClick = { onCancelClick() },
        onSubmitClick = { onSubmitClick() }
    )
}

@Composable
fun TaskCreateScreen(
    viewModel: TaskCreateViewModel,
    onCancelClick: () -> Unit,
    onSubmitClick: () -> Unit
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text("Create Reminder")
            },
                navigationIcon = {
                    IconButton(onClick = { onCancelClick() }) {
                        Icon(Icons.Filled.Close, "")
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onSubmitClick() },
            ) {
                Icon(Icons.Filled.AddTask, "Localized description")
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(paddingValues = it)
        ) {

            var title by remember { mutableStateOf("") }
            var description by remember { mutableStateOf("") }
            var date by remember { mutableStateOf("") }
            var time by remember { mutableStateOf("") }
            var type by remember { mutableStateOf("") }

            val mContext = LocalContext.current

            // Declaring integer values
            // for year, month and day
            val mYear: Int
            val mMonth: Int
            val mDay: Int

            // Initializing a Calendar
            val mCalendar = Calendar.getInstance()

            // Fetching current year, month and day
            mYear = mCalendar.get(Calendar.YEAR)
            mMonth = mCalendar.get(Calendar.MONTH)
            mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

            mCalendar.time = Date()

            // Declaring a string value to
            // store date in string format
            val mDate = remember { mutableStateOf("") }

            // Declaring DatePickerDialog and setting
            // initial values as current values (present year, month and day)
            val mDatePickerDialog = DatePickerDialog(
                mContext,
                { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                    mDate.value = "$mDayOfMonth/${mMonth + 1}"
                }, mYear, mMonth, mDay
            )
            mDatePickerDialog.datePicker.minDate =  System.currentTimeMillis()

            val mHour = mCalendar[Calendar.HOUR_OF_DAY]
            val mMinute = mCalendar[Calendar.MINUTE]

            // Value for storing time as a string
            val mTime = remember { mutableStateOf("") }

            // Creating a TimePicker dialog
            val mTimePickerDialog = TimePickerDialog(
                mContext,
                { _, mHour: Int, mMinute: Int ->
                    mTime.value = "$mHour:$mMinute"
                }, mHour, mMinute, false
            )

            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                val options =
                    listOf(
                        "General",
                        "Birthday",
                        "Anniversary",
                        "Meeting",
                        "Call",
                        "Shopping",
                        "Groceries"
                    )
                var expanded by remember { mutableStateOf(false) }
                var selectedOptionText by remember { mutableStateOf(options[0]) }

                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },
                ) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(),
                        readOnly = true,
                        value = selectedOptionText,
                        onValueChange = { type = it },
                        label = { Text("Category") },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                    ) {
                        options.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    selectedOptionText = selectionOption
                                    type = selectionOption
                                    expanded = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    value = title,
                    onValueChange = { title = it },
                    label = {
                        Text("Title")
                    },
                    keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Characters)
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row {
                    val dateSource = remember { MutableInteractionSource() }

                    if (dateSource.collectIsPressedAsState().value) {
                        mDatePickerDialog.show()
                    }

                    val timeSource = remember { MutableInteractionSource() }

                    if (timeSource.collectIsPressedAsState().value) {
                        mTimePickerDialog.show()
                    }

                    OutlinedTextField(
                        modifier = Modifier
                            .weight(1f),
                        value = mDate.value,
                        readOnly = true,
                        onValueChange = {},
                        interactionSource = dateSource,
                        label = { Text("Date") }
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    OutlinedTextField(
                        modifier = Modifier.weight(1f),
                        value = mTime.value,
                        readOnly = true,
                        interactionSource = timeSource,
                        onValueChange = { },
                        label = { Text("Time") }
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                    onClick = {
                        viewModel.createReminder(
                            reminder = Reminder(
                                title = title,
                                description = description,
                                date = date,
                                time = time,
                                type = type
                            )
                        )
                        onSubmitClick()
                    })
                {
                    Text(text = "Submit")
                }
            }
        }
    }
}