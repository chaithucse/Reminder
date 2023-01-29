package com.techchai.reminder.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class ScheduleAlarm(
    private val context: Context
) : AlarmScheduler {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    @RequiresApi(Build.VERSION_CODES.O)
    override fun schedule(alarm: Alarm) {
/*
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra("alarm", alarm)
        }

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            alarm.timeInMillis,
            createPendingIntent(alarm, intent = {
                intent
            })
        )*/
    }

    override fun cancel(alarm: Alarm) {

        alarmManager.cancel(
            createPendingIntent(alarm, intent = {
                Intent()
            })
        )
    }

    private fun createPendingIntent(alarm: Alarm, intent: () -> Intent): PendingIntent? {
        return PendingIntent.getBroadcast(
            context,
            alarm.id.toInt(),
            intent(),
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }
}