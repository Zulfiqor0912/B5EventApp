package uz.gita.b5eventapp.data

import android.content.Intent

data class Event(
    val id: Int,
//    @DrawableRes
//    val iconRes: Int,
    val name: String,
    val intent: String,
    var enabled: Boolean = false
)

val allEvents = listOf(
    Event(
        id = 1,
        name = "Screen On",
        intent = Intent.ACTION_SCREEN_ON
    ),
    Event(
        id = 2,
        name = "Screen Off",
        intent = Intent.ACTION_SCREEN_OFF
    ),
    Event(
        id = 3,
        name = "Power Connected",
        intent = Intent.ACTION_POWER_CONNECTED
    ),
    Event(
        id = 4,
        name = "Power Disconnected",
        intent = Intent.ACTION_POWER_DISCONNECTED
    ),
    Event(
        id = 5,
        name = "Device storage low",
        intent = Intent.ACTION_DEVICE_STORAGE_LOW
    ),
    Event(
        id = 6,
        name = "Plane",
        intent = Intent.ACTION_AIRPLANE_MODE_CHANGED
    ),
    Event(
        id = 7,
        name = "Battery ok",
        intent = Intent.ACTION_BATTERY_OKAY
    ),
    Event(
        id = 8,
        name = "Battery Low",
        intent = Intent.ACTION_BATTERY_LOW
    ),
    Event(
        id = 9,
        name = "Shut Down",
        intent = Intent.ACTION_SHUTDOWN
    ),
    Event(
        id = 10,
        name = "Time zone",
        intent = Intent.ACTION_TIMEZONE_CHANGED
    ),
    Event(
        id = 11,
        name = "Time changed",
        intent = Intent.ACTION_TIME_CHANGED
    ),
    Event(
        id = 12,
        name = "Data changed",
        intent = Intent.ACTION_DATE_CHANGED
    )
)

fun retrieveEnabledEvents() = allEvents.filter { it.enabled }

fun retrieveEnabledEventsAsArrayList(): ArrayList<String> {
    val enabledEvents = allEvents.filter { it.enabled }

    if (enabledEvents.isNullOrEmpty()) return arrayListOf()

    val result = arrayListOf<String>()
    enabledEvents.map { it.intent }.forEach { event ->
        result.add(event)
    }
    return result
}