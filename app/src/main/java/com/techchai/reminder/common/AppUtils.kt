package com.techchai.reminder.common

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object AppUtils {

    @SuppressLint("SimpleDateFormat")
    fun convertToDate(milliSeconds: String): String {
        try {
            val sdf = SimpleDateFormat("MMM, dd")
            val netDate = Date(milliSeconds.toLong())
            return sdf.format(netDate)
        } catch (e: Exception) {
            return e.toString()
        }
    }
}