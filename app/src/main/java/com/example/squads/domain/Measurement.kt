package com.example.squads.domain

import com.example.squads.database.measurements.DatabaseMeasurement
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import java.util.Date

data class Measurement(
    val id: Int,
    val weight: Double,
    val fatPercentage: Double,
    val musclePercentage: Double,
    val waistCircumference: Double,
    val measuredOn: LocalDateTime,
    val bmi: Double
)