package com.techchai.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.techchai.core.database.model.Reminder

@Database(entities = [Reminder::class], version = 3, exportSchema = false)
abstract class ReminderDatabase : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao
}