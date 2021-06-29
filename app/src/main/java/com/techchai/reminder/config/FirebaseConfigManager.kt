package com.techchai.reminder.config

import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.gson.Gson
import com.techchai.reminder.R
import com.techchai.reminder.common.APP_UPDATE
import com.techchai.reminder.config.model.AppUpdate


object FirebaseConfigManager {

    private lateinit var appUpdate: AppUpdate

    private val firebaseConfig by lazy {
        Firebase.remoteConfig
    }

    fun getAppUpdateConfig(): AppUpdate {
        return appUpdate
    }

    fun fetch() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 300
            fetchTimeoutInSeconds = 5
        }
        firebaseConfig.setConfigSettingsAsync(configSettings)

        firebaseConfig.setDefaultsAsync(R.xml.remote_config_default)
        firebaseConfig.fetchAndActivate().addOnCompleteListener {
            if (it.isSuccessful) {
                //TODO
            } else {
                //TODO
            }
            parseRemoteConfig()
        }
    }

    private fun parseRemoteConfig() {

        try {
            appUpdate =
                Gson().fromJson(firebaseConfig[APP_UPDATE].asString(), AppUpdate::class.java)
        } catch (e: Exception) {
        }
    }

    fun loadDefaultValues() {
        firebaseConfig.setDefaultsAsync(R.xml.remote_config_default)
        firebaseConfig.fetch()
    }
}