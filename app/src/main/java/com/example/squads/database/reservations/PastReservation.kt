package com.example.squads.database.reservations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * data class that stores the past reservations
 */
@Entity(tableName = "past_reservation")
data class PastReservation(
    @PrimaryKey
    val id: Int,
    val beginDate: Date,
    val endDate: Date,
    val sessionType: String,
    val trainerName: String,
    val sessionId: Int
)

/**
 * data class that stores the planned reservations
 */
@Entity(tableName = "planned_reservation")
data class PlannedReservation(
    @PrimaryKey
    val id: Int,
    val beginDate: Date,
    val endDate: Date,
    val sessionType: String,
    val trainerName: String,
    val sessionId: Int
)


@RequiresApi(Build.VERSION_CODES.O)
fun List<PastReservation>.asPastDomain(): List<PastReservation> {
    return map {
        PastReservation(
            id = it.id,
            beginDate = it.beginDate,
            endDate = it.endDate,
            trainerName = it.trainerName,
            sessionType = it.sessionType,
            sessionId = it.sessionId
            )
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun List<PlannedReservation>.asPlannedDomain(): List<PlannedReservation> {
    return map {
        PlannedReservation(
            id = it.id,
            beginDate = it.beginDate,
            endDate = it.endDate,
            trainerName = it.trainerName,
            sessionType = it.sessionType,
            sessionId = it.sessionId
        )
    }
}
