package com.techchai.reminder.data.db

import androidx.room.*
import com.techchai.reminder.data.model.Reminder
import kotlinx.coroutines.flow.Flow

@Dao
interface ReminderDao {

    @Query("SELECT * from reminder ORDER BY daysLeft ASC")
    fun getReminderList(): Flow<List<Reminder>>

    @Query("SELECT * from reminder WHERE category = :category ORDER BY daysLeft ASC")
    fun getReminderByType(category: String): Flow<List<Reminder>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(info: Reminder)

    @Delete
    suspend fun deleteReminder(reminder: Reminder)

    @Update
    suspend fun updateReminder(reminder: Reminder)
}