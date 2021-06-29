package com.techchai.reminder.config.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppUpdate(
    val view: View? = null,
    val enabled: Boolean? = null
) : Parcelable

@Parcelize
data class Description(
    val value: String? = null
) : Parcelable

@Parcelize
data class View(
    val button: Button? = null,
    val description: Description? = null,
    val title: Title? = null
) : Parcelable

@Parcelize
data class Button(
    val value: String? = null
) : Parcelable

@Parcelize
data class Title(
    val value: String? = null
) : Parcelable