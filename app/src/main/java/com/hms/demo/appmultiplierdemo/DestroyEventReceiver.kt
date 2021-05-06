package com.hms.demo.appmultiplierdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class DestroyEventReceiver:
    BroadcastReceiver() {
    var onDestroyEventListener: OnDestroyEventListener?=null

    fun register(context: Context) {
        context.registerReceiver(
            this,
            IntentFilter(BroadcastUtils.MULTIPLIER_NOTIFICATION)
        )
    }

    fun unregister(context: Context) {
        context.unregisterReceiver(this)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        onDestroyEventListener?.onActivityDestroyed()
    }

    interface OnDestroyEventListener {
        fun onActivityDestroyed()
    }
}