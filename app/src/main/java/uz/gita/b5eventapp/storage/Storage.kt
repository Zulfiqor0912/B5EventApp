package uz.gita.b5eventapp.storage

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor


class Storage private constructor(context: Context) {
    private lateinit var pref: SharedPreferences
    private lateinit var editor: Editor


    fun getIsScreen() = pref.getBoolean("SCREEN", false)
    fun getIsWiFi() = pref.getBoolean("WiFi", false)
    fun getIsBluetooth() = pref.getBoolean("BLUETOOTH", false)
    fun getIsHeadPhones() = pref.getBoolean("HEADPHONES", false)
    fun getIsPlane() = pref.getBoolean("PLANE", false)


    fun saveIsSCREEN(isClick: Boolean) {
        editor.putBoolean("SCREEN", isClick)
        editor.apply()
    }

    fun saveIsWiFi(isClick: Boolean) {
        editor.putBoolean("WiFi", isClick)
        editor.apply()
    }

    fun saveIsBluetooth(isClick: Boolean) {
        editor.putBoolean("BLUETOOTH", isClick)
        editor.apply()
    }

    fun saveIsHeadPhones(isClick: Boolean) {
        editor.putBoolean("HEADPHONES", isClick)
        editor.apply()
    }

    fun saveIsPlane(isClick: Boolean) {
        editor.putBoolean("PLANE", isClick)
        editor.apply()
    }


}