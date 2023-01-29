package com.techchai.core.domain

import com.techchai.core.data.RemindersRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetTaskUseCase @Inject constructor(
    private val remindersRepository: RemindersRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(taskId: String) {
        return withContext(defaultDispatcher) {
            remindersRepository.getReminderById(taskId)
        }
    }
}