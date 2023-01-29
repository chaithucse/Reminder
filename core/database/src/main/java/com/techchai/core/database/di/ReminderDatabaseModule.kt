package com.techchai.core.database.di

import android.content.Context
import androidx.room.Room
import com.techchai.core.database.ReminderDao
import com.techchai.core.database.ReminderDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ReminderDatabaseModule {

    @Provides
    @Singleton
    fun providesReminderDatabase(
        @ApplicationContext context: Context
    ): ReminderDatabase =
        Room.databaseBuilder(context, ReminderDatabase::class.java, "reminder").build()

    @Provides
    @Singleton
    fun providesReminderDao(database: ReminderDatabase): ReminderDao {
        return database.reminderDao()
    }
}