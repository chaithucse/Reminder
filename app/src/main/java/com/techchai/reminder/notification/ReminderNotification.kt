package com.techchai.reminder.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.os.Build

class ReminderNotification {

    fun createNotificationChannel(channelId: String, channelName: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_LOW
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = "Time for breakfast"

/* val notificationManager = requireActivity().getSystemService(
 NotificationManager::class.java
 )
 notificationManager.createNotificationChannel(notificationChannel)*/
        }
    }
}