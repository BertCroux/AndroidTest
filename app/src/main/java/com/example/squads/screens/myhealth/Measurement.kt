package com.example.squads.screens.myhealth

import kotlinx.datetime.LocalDateTime

data class Measurement(
    val Weight: Double,
    val FatPercentage: Double,
    val MusclePercentage: Double,
    val WaistCircumference: Double,
    val MeasuredOn: LocalDateTime
)