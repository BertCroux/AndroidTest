package com.example.squads.screens.exercises

import java.time.LocalDateTime

data class PersonalRecord(
    val id: Int,
    val userId: Int,
    val exerciseId: Int,
    val amountOfReps: Int,
    val weightUsed: Double,
    val achievedOn: LocalDateTime
)
