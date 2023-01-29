package com.techchai.core.data.di

import com.techchai.core.data.ReminderRepositoryImpl
import com.techchai.core.data.RemindersRepository
import com.techchai.core.database.ReminderDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideRepository(dao: ReminderDao) : RemindersRepository {
        return ReminderRepositoryImpl(dao)
    }

    @Provides
    fun provideCoroutineDispatcher() : CoroutineDispatcher = Dispatchers.Default
}