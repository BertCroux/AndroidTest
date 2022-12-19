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

    @RequiresApi(Build.VERSION_CODES.O)
    val reservations = repository.reservations
    private val _reservations = reservations.value;


    fun getSessions(){
        Log.d("SessionViewModel", reservations.value.toString())
        /*_sessions.value = listOf(
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
        )*/
    }
    init {
        viewModelScope.launch {
            repository.refreshReservations()
        }
        getSessions()
    }

    private val _pastReservations = MutableLiveData<List<com.example.squads.domain.accounts.Reservation>>()
    val pastReservation: LiveData<List<com.example.squads.domain.accounts.Reservation>>
        get() = _pastReservations

    private val _plannedReservations = MutableLiveData<List<com.example.squads.domain.accounts.Reservation>>()
    val plannedReservation: LiveData<List<com.example.squads.domain.accounts.Reservation>>
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
        val toLocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.UTC)
        _plannedReservations.value = _reservations?.filter {
            it.endDate > Date.from(toLocalDateTime.date.toJavaLocalDate()
                .atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())
        }
    }

    /**
     * @see https://kotlinlang.org/docs/collection-filtering.html
     *
     */
    fun getPastReservations() {
        Log.d("ReservationViewModel", Clock.System.now().toLocalDateTime(TimeZone.UTC).toString())
        val toLocalDateTime = Clock.System.now().toLocalDateTime(TimeZone.UTC)

        _pastReservations.value = _reservations?.filter {
            Date.from(toLocalDateTime.date.toJavaLocalDate()
                .atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()) > it.endDate
        }
    }
}
