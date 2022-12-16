package com.example.squads.database.accounts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reservation")
data class Reservation(
    @PrimaryKey
    val id: Int,
    val beginDate: String,
    val endDate: String,
    val trainerName: String,
    val trainerType: String,
    val sessionId: Int
)

fun Reservation.asDomain(): com.example.squads.domain.accounts.Reservation {
    return com.example.squads.domain.accounts.Reservation(
        id = id,
        startDate = beginDate,
        endDate = endDate,
        sessionType = trainerType,
        trainer = trainerName,
        sessionId = sessionId
    )
}