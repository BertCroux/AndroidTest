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
data class DatabasePastReservation(
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
data class DatabasePlannedReservation(
    @PrimaryKey
    val id: Int,
    val beginDate: Date,
    val endDate: Date,
    val sessionType: String,
    val trainerName: String,
    val sessionId: Int
)

//TODO: look at implementation: this breaks if you change this to real domain
// objects for the ListView
/**
 * Converts a DB object (DatabasePastReservation) to domain objects (PastReservation)
 */
@RequiresApi(Build.VERSION_CODES.O)
fun List<DatabasePastReservation>.asPastDomain(): List<DatabasePastReservation> {
    return map {
        DatabasePastReservation(
            id = it.id,
            beginDate = it.beginDate,
            endDate = it.endDate,
            trainerName = it.trainerName,
            sessionType = it.sessionType,
            sessionId = it.sessionId
        )
    }
}

//TODO: look at implementation: this breaks if you change this to real domain
// objects for the ListView
/**
 * Converts a DB object (DatabasePlannedReservation) to domain objects (PlannedReservation)
 */
@RequiresApi(Build.VERSION_CODES.O)
fun List<DatabasePlannedReservation>.asPlannedDomain(): List<DatabasePlannedReservation> {
    return map {
        DatabasePlannedReservation(
            id = it.id,
            beginDate = it.beginDate,
            endDate = it.endDate,
            trainerName = it.trainerName,
            sessionType = it.sessionType,
            sessionId = it.sessionId
        )
    }
}
