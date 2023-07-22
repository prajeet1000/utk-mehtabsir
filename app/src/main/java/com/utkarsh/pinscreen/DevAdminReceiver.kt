package com.utkarsh.pinscreen

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

open class DevAdminReceiver: DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        Toast.makeText(context, "Admin is enabled", Toast.LENGTH_SHORT).show()
    }
    override fun onLockTaskModeEntering(context: Context, intent: Intent, pkg: String) {
        Toast.makeText(context, "Lock task mode entered", Toast.LENGTH_LONG).show()
        // ....
    }

    override fun onLockTaskModeExiting(context: Context, intent: Intent) {
        Toast.makeText(context, "Lock task mode exited", Toast.LENGTH_LONG).show()
        // ...
    }
}