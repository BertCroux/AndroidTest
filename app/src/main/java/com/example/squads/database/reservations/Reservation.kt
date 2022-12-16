package com.example.squads.database.reservations

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime
import java.time.LocalDate
import java.util.Date

@Entity(tableName = "reservation")
data class Reservation(
    @PrimaryKey
    val id: Int,
    val beginDate: Date,
    val endDate: Date,
    val trainerType: String,
    val trainerName: String,
    val sessionId: Int
)