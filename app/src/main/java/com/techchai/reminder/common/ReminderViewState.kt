package com.techchai.reminder.common

import com.techchai.reminder.data.model.Reminder

sealed class ReminderViewState {
    object Empty : ReminderViewState()
    object Loading : ReminderViewState()
    data class Success(val notes: List<Reminder>) : ReminderViewState()
    data class Error(val exception: Throwable) : ReminderViewState()
}