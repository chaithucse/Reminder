package com.techchai.core.domain

import com.techchai.core.data.RemindersRepository
import com.techchai.core.database.model.Reminder
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskListUseCase @Inject constructor(
    private val remindersRepository: RemindersRepository
) {
    operator fun invoke(): Flow<List<Reminder>> = remindersRepository.getReminders()
}