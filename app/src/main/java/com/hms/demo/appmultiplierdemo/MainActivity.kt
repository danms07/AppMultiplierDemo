package com.hms.demo.appmultiplierdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener,DestroyEventReceiver.OnDestroyEventListener {
    private var receiver:DestroyEventReceiver?=null

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val b1: Button = findViewById(R.id.button1)
        val b2: Button = findViewById(R.id.button2)
        val b3: Button = findViewById(R.id.button3)
        b1.setOnClickListener(this)
        b2.setOnClickListener(this)
        b3.setOnClickListener(this)

        val config: String = resources.configuration.toString()
        val isInMagicWindow =
            config.contains("hwMultiwindow-magic") || config.contains("hw-magic-windows")
        val message="Magic window: ${if(isInMagicWindow) "true" else "false"}"
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        val orientation= resources.configuration.orientation

        //Force to show in full screen
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        //Register a receiver to be notified when another activity is destroyed
        receiver=DestroyEventReceiver().apply {
            onDestroyEventListener=this@MainActivity
            register(this@MainActivity)
        }
        //Back to split view
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    }

    override fun onClick(v: View?) {
        val intent: Intent = when (v?.id) {
            R.id.button1 -> {
                Intent(this, RedActivity::class.java)
            }
            R.id.button2 -> {
                Intent(this, GreenActivity::class.java)
            }
            R.id.button3 -> {
                Intent(this, BlueActivity::class.java)
            }
            else -> {
                Intent(this, RedActivity::class.java)
            }
        }

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)

        startActivity(intent)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onActivityDestroyed() {
        if(isTaskRoot){
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }
}
