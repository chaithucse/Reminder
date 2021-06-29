package com.techchai.reminder.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.techchai.reminder.R

class AlarmReceiver : BroadcastReceiver() {
    private val CHANNEL_ID = "reminder"

    override fun onReceive(context: Context?, intent: Intent?) {

        val builder = NotificationCompat.Builder(context!!, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Much longer text that cannot fit one line...")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Much longer text that cannot fit one line...")
            )
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }
    }
}