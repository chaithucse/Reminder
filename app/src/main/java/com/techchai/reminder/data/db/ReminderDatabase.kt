package com.techchai.reminder.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.techchai.reminder.data.model.Reminder

@Database(entities = [Reminder::class], version = 1)
abstract class ReminderDatabase : RoomDatabase() {

    abstract fun reminderDao(): ReminderDao

    companion object {
        private var instance: ReminderDatabase? = null

        fun getDatabaseClient(context: Context): ReminderDatabase {
            if (null == instance) {
                synchronized(ReminderDatabase::class.java) {
                    instance =
                        Room.databaseBuilder(context, ReminderDatabase::class.java, "reminder.db")
                            .build()
                }
            }
            return instance!!
        }
    }
}