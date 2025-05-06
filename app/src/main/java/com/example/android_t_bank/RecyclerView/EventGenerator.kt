package com.example.android_t_bank.RecyclerView

import com.example.android_t_bank.R


object  EventGenerator {
    private val imageIdList: List<Int> = listOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.baseline_360_24,
        R.drawable.baseline_3d_rotation_24,
        R.drawable.baseline_4g_plus_mobiledata_24
    )

    fun generateEvents(count: Int): List<Event> =
        (0 .. count).map{ index ->
            Event(imageRestId = imageIdList.random(),
               name = "Событие ${index}",
                time = "${(12 .. 23).random()}:${(10 .. 59).random()}")
        }
}