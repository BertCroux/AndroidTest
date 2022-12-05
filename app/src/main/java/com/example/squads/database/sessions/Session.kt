package com.example.squads.database.sessions

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "session")
data class Session(
    @PrimaryKey
    val id: Int,
    val beginDate: LocalDateTime,
    val endDate: LocalDateTime,
    val SessionType: String,
    val Instructor: String,
)