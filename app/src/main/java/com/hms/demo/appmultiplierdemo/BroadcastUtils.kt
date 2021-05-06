package com.hms.demo.appmultiplierdemo

import android.content.Context
import android.content.Intent

object BroadcastUtils {
    const val MULTIPLIER_NOTIFICATION = "com.hms.demo.appmultiplierdemo.onDestroy"

    fun sendDestroyNotification(context: Context) {
        val intent = Intent()
        intent.action = MULTIPLIER_NOTIFICATION
        context.sendBroadcast(intent)
    }
}