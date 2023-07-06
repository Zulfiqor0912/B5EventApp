package uz.gita.b5eventapp

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import uz.gita.b5eventapp.data.allEvents


class EventReceiver : BroadcastReceiver() {
    private lateinit var mediaPlayer: MediaPlayer
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("TTT", "onReceive() -> ${intent?.action}")
        mediaPlayer = MediaPlayer.create(context, R.raw.sound)
        scope.launch {
            allEvents.filter { it.enabled }.find { it.intent == intent?.action }?.let {
                mediaPlayer.start()
            }
        }
    }

    fun clearReceiver() {
        scope.cancel()
    }
}