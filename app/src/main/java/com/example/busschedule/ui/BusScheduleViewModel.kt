package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.BusScheduleApplication
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.ScheduleDao
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(
    private val scheduleDao: ScheduleDao
) : ViewModel() {

    fun getFullSchedule(): Flow<List<BusSchedule>> {
        return scheduleDao.getAll()
    }

    fun getScheduleFor(
        stopName: String
    ): Flow<List<BusSchedule>> {
        return scheduleDao.getByStopName(stopName)
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                            as BusScheduleApplication

                BusScheduleViewModel(
                    application.database.scheduleDao()
                )
            }
        }
    }
}
