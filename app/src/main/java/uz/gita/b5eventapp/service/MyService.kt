package uz.gita.b5eventapp.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import uz.gita.b5eventapp.EventReceiver
import uz.gita.b5eventapp.R

class MyService : Service() {
    private val receiver = EventReceiver()

    companion object {
        const val CHANEL_ID = "EVENT"
        const val STOP_SERVICE = "STOP"
        const val ENABLED_EVENTS = "Enabled Events"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d("TTT", "onCreate: Service creating")
        createChannel()
        startService()
        registerIntents()
    }

    private fun registerIntents() {
        registerReceiver(receiver, IntentFilter().apply {
            addAction("android.intent.action.SCREEN_ON")
            addAction("android.intent.action.SCREEN_OFF")
            addAction("android.intent.action.TIMEZONE_CHANGED")
            addAction("android.intent.action.DATE_CHANGED")
            addAction("android.intent.action.BATTERY_LOW")
            addAction("android.intent.action.BATTERY_OKAY")
            addAction("android.intent.action.ACTION_SHUTDOWN")
            addAction("android.intent.action.AIRPLANE_MODE")
            addAction("android.intent.action.ACTION_POWER_CONNECTED")
            addAction("android.intent.action.ACTION_POWER_DISCONNECTED")
        })
    }

    override fun onBind(intent: Intent?) = null


    fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(CHANEL_ID, "EVENT", NotificationManager.IMPORTANCE_DEFAULT)
            channel.setSound(null, null)
            val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            service.createNotificationChannel(channel)
        }
    }

    private fun startService() {

        val stopIntent = Intent(this, MyService::class.java)
        stopIntent.putExtra(STOP_SERVICE, true)
        val stopPendingIntent = PendingIntent
            .getService(
                this,
                1,
                stopIntent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )

        val notification = NotificationCompat.Builder(this, CHANEL_ID)
            .setOngoing(true)
            .setSmallIcon(R.mipmap.ic_launcher_round)
            .addAction(R.drawable.ic_close, STOP_SERVICE, stopPendingIntent)
            .build()

        startForeground(1, notification)
    }


    override fun onDestroy() {
        super.onDestroy()
        receiver.clearReceiver()
        unregisterReceiver(receiver)
    }
}
