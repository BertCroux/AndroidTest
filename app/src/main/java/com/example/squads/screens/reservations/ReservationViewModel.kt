package com.example.squads.screens.reservations

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.database.sessions.asDomain
import com.example.squads.repository.accounts.AccountRepository
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toLocalDateTime
import java.time.ZoneId
import java.util.Date

@RequiresApi(Build.VERSION_CODES.O)
class ReservationViewModel(application : Application) : AndroidViewModel(application) {

    private val database = SquadsRoomDatabase.getInstance(application.applicationContext)
    private val repository = AccountRepository(database)



    init {
        viewModelScope.launch {
            repository.refreshReservations()
        }
    }

    val pastReservation = repository.pastRes
    val plannedReservation = repository.plannedRes

}
