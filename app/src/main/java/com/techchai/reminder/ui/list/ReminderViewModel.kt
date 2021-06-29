package com.techchai.reminder.ui.list

import androidx.lifecycle.*
import com.techchai.reminder.ReminderApplication
import com.techchai.reminder.data.ReminderRepository
import com.techchai.reminder.data.db.ReminderDatabase
import com.techchai.reminder.data.model.Reminder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class ReminderViewModel() : ViewModel() {

    private var repository: ReminderRepository = ReminderRepository(
        ReminderDatabase.getDatabaseClient(
            ReminderApplication.applicationContext()).reminderDao())

    private val _reminderList = MutableStateFlow<List<Reminder>>(Collections.emptyList())
    val reminderList = _reminderList.asStateFlow()

    init {
        viewModelScope.launch {
            repository.reminderList.collect {
                _reminderList.value = it
            }
        }
    }

    fun deleteReminder(reminder: Reminder) {

    }

    fun updateReminder(reminder: Reminder) {

    }
}

/*
class ReminderViewModelFactory(private val repository: ReminderRepository) :
 ViewModelProvider.Factory {
 override fun <T : ViewModel> create(modelClass: Class<T>): T {
 if (modelClass.isAssignableFrom(ReminderViewModel::class.java)) {
 @Suppress("UNCHECKED_CAST")
 return ReminderViewModel() as T
 }
 throw IllegalArgumentException("Unknown ViewModel class")
 }
}*/