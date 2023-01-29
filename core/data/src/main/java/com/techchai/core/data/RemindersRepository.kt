package com.techchai.core.data

import com.techchai.core.database.model.Reminder
import kotlinx.coroutines.flow.Flow

interface RemindersRepository {
    fun getReminders(): Flow<List<Reminder>>
    fun getRemindersByType(type: String): Flow<List<Reminder>>
    suspend fun getReminderById(taskId: String)
    suspend fun insertReminder(reminder: Reminder)
    suspend fun updateReminder(reminder: Reminder)
    suspend fun deleteReminder(reminder: Reminder)
}