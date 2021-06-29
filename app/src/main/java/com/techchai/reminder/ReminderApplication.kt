package com.techchai.reminder

import android.app.Application
import android.content.Context
import com.techchai.reminder.config.FirebaseConfigManager

class ReminderApplication : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: ReminderApplication? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        val context: Context = ReminderApplication.applicationContext()
        FirebaseConfigManager.loadDefaultValues()
    }
}