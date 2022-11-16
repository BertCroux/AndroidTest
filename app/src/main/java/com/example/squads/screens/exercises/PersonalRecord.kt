package com.example.squads.screens.exercises

import java.time.LocalDate

data class PersonalRecord(
    val id: Int,
    val userId: Int,
    val exerciseId: Int,
    val amountOfReps: Int,
    val weightUsed: Double,
    val achievedOn: LocalDate
)
