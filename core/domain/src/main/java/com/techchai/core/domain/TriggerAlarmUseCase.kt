package com.techchai.core.domain

import android.os.Build
import androidx.annotation.RequiresApi
import com.techchai.reminder.alarm.Alarm
import com.techchai.reminder.alarm.ScheduleAlarm
import javax.inject.Inject

class TriggerAlarmUseCase @Inject constructor(private val scheduler : ScheduleAlarm) {

    @RequiresApi(Build.VERSION_CODES.O)
    operator fun invoke(alarm: Alarm) {
        scheduler.schedule(alarm)
    }
}