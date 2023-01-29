package com.techchai.core.domain

import com.techchai.core.data.RemindersRepository
import com.techchai.core.database.model.Reminder
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class InsertTaskUseCase @Inject constructor(
    private val remindersRepository: RemindersRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(reminder: Reminder) {
        return withContext(defaultDispatcher) {
            remindersRepository.insertReminder(reminder)
        }
    }
}