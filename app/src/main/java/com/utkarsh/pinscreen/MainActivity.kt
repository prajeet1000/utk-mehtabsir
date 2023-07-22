package com.utkarsh.pinscreen

import android.app.ActivityManager
import android.app.NotificationManager
import android.app.admin.DevicePolicyManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.annotation.RequiresApi


class MainActivity : ComponentActivity() {
    private val KIOSK_PACKAGE = "com.utkarsh.pinscreen"
    private val APP_PACKAGES = arrayOf(KIOSK_PACKAGE)
    lateinit var myDevicePolicyManager: DevicePolicyManager
    lateinit var mNotificationManager: NotificationManager
    val packages = arrayOf(KIOSK_PACKAGE)
    lateinit var homeWatcher: HomeWatcher

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.screen_pin)
        val start = findViewById<Button>(R.id.start)
        val stop = findViewById<Button>(R.id.stop)
        homeWatcher = HomeWatcher(this)
        homeWatcher.setOnHomePressedListener(object : OnHomePressedListener {
            override fun onHomePressed() {
                Toast.makeText(this@MainActivity, "KEYCODE_HOME", Toast.LENGTH_SHORT).show()
                Log.d("KeyPressed", "KEYCODE_HOME")
            }

            override fun onRecentAppPressed() {
                Toast.makeText(this@MainActivity, "onRecentAppPressed", Toast.LENGTH_SHORT).show()
                Log.d("KeyPressed", "onRecentAppPressed")
            }

        })
        homeWatcher.startWatch()

//        val mReceiver = InnerReceiver()
//        val mFilter = IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
//        registerReceiver(mReceiver, mFilter)
//        myDevicePolicyManager = getSystemService(DEVICE_POLICY_SERVICE) as DevicePolicyManager
//        var mDeviceAdminSample = ComponentName(this, DevAdminReceiver::class.java)
//        mNotificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Check if the notification policy access has been granted for the app.


        // Check if the notification policy access has been granted for the app.
//        if (!mNotificationManager.isNotificationPolicyAccessGranted) {
//            val intent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
//            startActivityForResult(intent, 100)
//        }else
//        {
//            mNotificationManager.notificationPolicy = NotificationManager.Policy(
//                NotificationManager.Policy.PRIORITY_CATEGORY_CALLS,
//                NotificationManager.Policy.PRIORITY_CATEGORY_MESSAGES,
//                NotificationManager.Policy.PRIORITY_CATEGORY_SYSTEM
//            )
//
//            mNotificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_PRIORITY)
//            val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
//            audioManager.ringerMode = AudioManager.RINGER_MODE_SILENT
//        }
//        updateAppPinnableChk()
// Start our kiosk app's main activity with our lock task mode option.
//        var activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        start.setOnClickListener {

//            myDevicePolicyManager.setLockTaskPackages(mDeviceAdminSample, packages)

//            if (activityManager.lockTaskModeState == 0) {
            startLockTask()
//
//            }
//            Handler(Looper.getMainLooper()).postDelayed(Runnable {
//                if (activityManager.lockTaskModeState == 2) {
//                    Toast.makeText(this, "Screen pinned successfully", Toast.LENGTH_SHORT).show()
//                }
//            }, 2000)


        }
        stop.setOnClickListener {

            stopLockTask()


        }
    }

    override fun onResume() {
        super.onResume()
        if (homeWatcher != null)
            homeWatcher.startWatch()
    }

    override fun onPause() {
        super.onPause()
        if (homeWatcher != null)
            homeWatcher.stopWatch()
    }

}