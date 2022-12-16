package com.example.squads.screens.sessions

import android.app.Application
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.*
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.database.measurements.asDomain
import com.example.squads.database.sessions.asDomain
import com.example.squads.repository.measurements.MeasurementRepository
import com.example.squads.repository.sessions.SessionRepository
import com.example.squads.screens.reservations.Reservation
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class SessionViewModel(application: Application) : AndroidViewModel(application) {

    // list of all the users measurements
    private val database = SquadsRoomDatabase.getInstance(application.applicationContext)
    private val repository = SessionRepository(database)

    @RequiresApi(Build.VERSION_CODES.O)
    val sessions = Transformations.map(repository.allSessions.asLiveData()) {
        it.asDomain()
    }

    init {
        viewModelScope.launch {
            repository.refreshSessions()
        }
    }

    fun ReserveSession(reservation: com.example.squads.network.accounts.Reservation){
        
    }




    private val _navigateFromSession = MutableLiveData<Boolean?>()
    val navigateFromSession: LiveData<Boolean?>
        get() = _navigateFromSession

    fun doneNavigatingFromSession() {
        _navigateFromSession.value = null
    }

    fun onNavigateFromSession() {
        _navigateFromSession.value = true
    }




}