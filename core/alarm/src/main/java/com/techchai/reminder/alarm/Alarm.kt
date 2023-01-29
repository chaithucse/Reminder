package com.techchai.reminder.alarm

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.ZoneId

data class Alarm(
    val time: LocalDateTime,
    val title: String,
    val navigationUrl: String,
    val id: Long,
) {

    val timeInMillis @RequiresApi(Build.VERSION_CODES.O)
    get() = time.atZone(ZoneId.systemDefault()).toEpochSecond().times(1000)
}