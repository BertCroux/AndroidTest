package com.example.squads.database.sessions

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "session")
data class Session(
    @PrimaryKey
    val id: Int,
    val startDate: Date,
    val endDate: Date,
    val SessionType: String,
    val Instructor: String,
)