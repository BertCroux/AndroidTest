package com.example.squads.screens.myhealth

import kotlinx.datetime.LocalDateTime

data class Measurement(
    val weight: Double,
    val fatPercentage: Double,
    val musclePercentage: Double,
    val waistCircumference: Double,
    val measuredOn: LocalDateTime
)
