package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(
            "MyBroadcastReceiver",
            "Broadcast received"
        )
        Log.d(
            "MyBroadcastReceiver",
            "Action: ${intent.action}"
        )
        if (intent.action == "com.example.MY_ACTION") {
            Log.d(
                "MyBroadcastReceiver",
                "Custom action received"
            )
            val message =
                intent.getStringExtra("message")
        }
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network: Network? = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        if (capabilities != null) {
            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                Toast.makeText(context, "Wi-Fi is connected", Toast.LENGTH_SHORT).show()
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                Toast.makeText(context, "Mobile data is connected", Toast.LENGTH_SHORT)
                    .show()
            }
        } else {
            Toast.makeText(context, "No network connection", Toast.LENGTH_SHORT).show()
        }
    }
}