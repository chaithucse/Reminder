package com.techchai.reminder.data

import com.techchai.reminder.data.db.ReminderDao
import com.techchai.reminder.data.model.Reminder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class ReminderRepository(private val reminderDao: ReminderDao) {

    val reminderList: Flow<List<Reminder>> = flow {
        reminderDao.getReminderList()
    }

    suspend fun insertReminder(reminder: Reminder) {
        withContext(Dispatchers.IO) {
            reminderDao.insertReminder(reminder)
        }
    }

    suspend fun deleteReminder(reminder: Reminder) {
        reminderDao.deleteReminder(reminder)
    }

    suspend fun updateReminder(reminder: Reminder) {
        reminderDao.updateReminder(reminder)
    }
}