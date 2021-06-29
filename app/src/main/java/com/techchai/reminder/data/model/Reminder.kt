package com.techchai.reminder.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String?,
    var date: String?,
    var time: String?,
    var category: String?,
    var isNotified: Boolean? = false,
    var daysLeft: Int? = 0,
    var repeatTime: String? = "",
    var snoozeTime: String? = "",
    var notes: String? = "",
    var status: String? = ""
)