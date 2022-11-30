package com.example.squads.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDateTime

@Entity(tableName = "measurement")
data class Measurement(
    @PrimaryKey
    val id: Int,
    val weight: Double,
    val fatPercentage: Double,
    val musclePercentage: Double,
    val waistCircumference: Double,
    val measuredOn: LocalDateTime
)