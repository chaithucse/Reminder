package com.techchai.feature.tasklist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techchai.core.database.model.Reminder
import com.techchai.core.domain.GetTaskListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class TaskListViewModel @Inject constructor(private val taskListUseCase: GetTaskListUseCase) :
    ViewModel() {

    val uiState: StateFlow<TaskListUiState> = taskListUseCase().mapToUiState().stateIn(
        viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = TaskListUiState.Loading
    )
}

sealed interface TaskListUiState {
    object Loading : TaskListUiState
    data class Success(val data: List<Reminder>) : TaskListUiState
}

private fun Flow<List<Reminder>>.mapToUiState(): Flow<TaskListUiState> =
    map<List<Reminder>, TaskListUiState>(TaskListUiState::Success).onStart {
        emit(TaskListUiState.Loading)
    }