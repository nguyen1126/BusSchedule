package com.example.busschedule

import android.app.Application
import androidx.room.Room
import com.example.busschedule.data.ScheduleDatabase

class BusScheduleApplication : Application() {

    val database: ScheduleDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            ScheduleDatabase::class.java,
            "bus_schedule_database"
        ).createFromAsset("database/bus_schedule.db")
            .build()
    }
}
