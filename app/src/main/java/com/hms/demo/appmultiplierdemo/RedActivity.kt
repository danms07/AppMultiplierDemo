package com.hms.demo.appmultiplierdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_red)
    }

    override fun onDestroy() {
        BroadcastUtils.sendDestroyNotification(this)
        super.onDestroy()
    }
}
