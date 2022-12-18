package com.example.squads.database.accounts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservation")
data class DatabaseReservation(
    @PrimaryKey
    val id: Int,
    val beginDate: String,
    val endDate: String,
    val trainerName: String,
    val trainerType: String,
    val sessionId: Int
)

fun DatabaseReservation.asDomain(): com.example.squads.domain.accounts.Reservation {
    return com.example.squads.domain.accounts.Reservation(
        id = id,
        startDate = beginDate,
        endDate = endDate,
        sessionType = trainerType,
        trainer = trainerName,
        sessionId = sessionId
    )
}
fun List<DatabaseReservation>.asDomain(): List<com.example.squads.domain.accounts.Reservation> {
    return map {
        com.example.squads.domain.accounts.Reservation(
            id = it.id,
            startDate = it.beginDate,
            endDate = it.endDate,
            sessionType = it.trainerType,
            trainer = it.trainerName,
            sessionId = it.sessionId
        )
    }
}