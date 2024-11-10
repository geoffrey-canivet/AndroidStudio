package com.example.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isAirplaneModeEnabled = intent.getBooleanExtra("state", false)
            val message = if(isAirplaneModeEnabled) "Airplane activé" else "Airplane Mode desactivé"
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }
}