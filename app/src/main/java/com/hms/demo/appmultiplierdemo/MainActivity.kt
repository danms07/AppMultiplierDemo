package com.hms.demo.appmultiplierdemo

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

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

        val config: String = getResources().getConfiguration().toString()
        val isInMagicWindow =
            config.contains("hwMultiwindow-magic") || config.contains("hw-magic-windows")
        val message="Magic window: ${if(isInMagicWindow) "true" else "false"}"
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        val orientation=getResources().getConfiguration().orientation

        //Force to show in full screen
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)

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
        startActivity(intent)
    }
}
