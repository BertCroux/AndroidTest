package com.example.squads.screens.sessions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squads.screens.reservations.Reservation
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class SessionViewModel : ViewModel() {


    val _sessions = MutableLiveData<List<Session>>()
    val sessions: LiveData<List<Session>>
        get() = _sessions

    fun getSessions(){
        _sessions.value = listOf(
            Session(
                LocalDateTime(2022, 11, 1, 19, 0, 0, 0),
                LocalDateTime(2022, 11, 1, 20, 0, 0, 0),
                "Heavy workout", "Beast mode.", 6
            ),
            Session(
                LocalDateTime(2022, 11, 2, 19, 0, 0, 0),
                LocalDateTime(2022, 11, 2, 20, 0, 0, 0),
                "Yoga", "Hells.", 5
            )
        )
    }
    init {
        getSessions()
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