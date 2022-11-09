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
    private val _sessions = listOf(
        Session(
        LocalDateTime(2022, 11, 1, 19, 0, 0, 0),
        LocalDateTime(2022, 11, 1, 12, 0, 0, 0),
        "Heavy workout", "Beast mode.", 6)
    )


    init {
    }

    /**
     * @see https://kotlinlang.org/docs/collection-filtering.html
     *
     */
    /*fun getSessions() {
        _sessions.value = _sessions.filter {
            it.endDate >= Clock.System.now().toLocalDateTime(TimeZone.UTC)
        }
    }*/


}