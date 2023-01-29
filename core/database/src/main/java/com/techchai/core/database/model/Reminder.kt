package com.techchai.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminder")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val type: String? = null,
    val title: String? = null,
    val description : String? = null,
    val date: String? = null,
    val time: String? = null,
    val notes: String? = null,
    val daysLeft: Int? = null,
    val isNotified: String? = null,
    val phoneNumber: String? = null,
)