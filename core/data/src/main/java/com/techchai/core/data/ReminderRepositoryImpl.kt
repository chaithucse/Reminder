package com.techchai.core.data

import com.techchai.core.database.model.Reminder
import com.techchai.core.database.ReminderDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ReminderRepositoryImpl @Inject constructor(
    private val reminderDao: ReminderDao
) : RemindersRepository {

    override fun getReminders(): Flow<List<Reminder>> {
        return reminderDao.getAllReminders()
    }

    override suspend fun getReminderById(taskId: String) {
        TODO("Not yet implemented")
    }

    override fun getRemindersByType(type: String): Flow<List<Reminder>> {
        return reminderDao.getReminderByType(type)
    }

    override suspend fun insertReminder(reminder: Reminder) {
        withContext(Dispatchers.IO) {
            reminderDao.insertReminder(reminder)
        }
    }

    override suspend fun updateReminder(reminder: Reminder) {
        withContext(Dispatchers.IO) {
            reminderDao.updateReminder(reminder)
        }
    }

    override suspend fun deleteReminder(reminder: Reminder) {
        withContext(Dispatchers.IO) {
            reminderDao.deleteReminder(reminder)
        }
    }
}