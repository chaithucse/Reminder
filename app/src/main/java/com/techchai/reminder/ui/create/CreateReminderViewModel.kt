package com.techchai.reminder.ui.create

import androidx.lifecycle.*
import com.techchai.reminder.ReminderApplication
import com.techchai.reminder.data.ReminderRepository
import com.techchai.reminder.data.db.ReminderDatabase
import com.techchai.reminder.data.model.Reminder
import kotlinx.coroutines.launch

class CreateReminderViewModel : ViewModel() {

    var repository: ReminderRepository = ReminderRepository(ReminderDatabase.getDatabaseClient(ReminderApplication.applicationContext()).reminderDao())

    private var _createDate = MutableLiveData<String>()
    val createDate: LiveData<String> = _createDate

    private var _createTime = MutableLiveData<String>()
    val createTime: LiveData<String> = _createTime

    private var _category = MutableLiveData<String>()
    val category: LiveData<String> = _category

    private var _reminderName = MutableLiveData<String>()
    val reminderName : LiveData<String> = _reminderName

    fun setReminderName(name: String) {
        _reminderName.value = name
    }

    fun setReminderDate(date: String) {
        _createDate.value = date
    }

    fun setReminderTime(time: String) {
        _createTime.value = time
    }

    fun setCategory(name: String) {
        _category.value = name
    }

    fun saveReminder() {
        val reminder = Reminder(name = reminderName.value, date = createDate.value, time = createTime.value, category = category.value)
        viewModelScope.launch {
            repository.insertReminder(reminder)
        }
    }
}

class CreateReminderViewModelFactory(private val repository: ReminderRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreateReminderViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CreateReminderViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}