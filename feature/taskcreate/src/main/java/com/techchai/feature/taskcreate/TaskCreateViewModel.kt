package com.techchai.feature.taskcreate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techchai.core.database.model.Reminder
import com.techchai.core.domain.InsertTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskCreateViewModel @Inject constructor(private val taskInsertUseCase: InsertTaskUseCase) :
    ViewModel() {

    fun createReminder(reminder: Reminder) {
        viewModelScope.launch {
            taskInsertUseCase(reminder)
        }
    }
}
