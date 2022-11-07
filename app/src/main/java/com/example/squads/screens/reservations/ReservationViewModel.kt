package com.example.squads.screens.reservations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class ReservationViewModel: ViewModel() {

    //reservations of 'a user' (not specified atm)
    private val _reservations = listOf(Reservation(
        LocalDateTime(2022, 10, 3, 19, 0, 0, 0),
        LocalDateTime(2022, 10, 3, 19, 0, 0, 0),
         "Heavy workout", "Beast mode"))

    private val _pastReservations = MutableLiveData<List<Reservation>>()
    val pastReservation: LiveData<List<Reservation>>
        get() = _pastReservations

    private val _plannedReservations = MutableLiveData<List<Reservation>>()
    val plannedReservation: LiveData<List<Reservation>>
        get() = _plannedReservations

    init {
        getPastReservations()
        getPlannedReservations()
    }

    /**
     * @see https://kotlinlang.org/docs/collection-filtering.html
     *
     */
    fun getPlannedReservations() {
        _plannedReservations.value = _reservations.filter {
            it.endDate >= Clock.System.now().toLocalDateTime(TimeZone.UTC)
        }
    }

    /**
     * @see https://kotlinlang.org/docs/collection-filtering.html
     *
     */
    fun getPastReservations() {
        _pastReservations.value = _reservations.filter {
            it.endDate < Clock.System.now().toLocalDateTime(TimeZone.UTC)
        }
    }
}