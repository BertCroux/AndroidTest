package com.example.squads.domain.accounts

import java.util.Date

/**
 * Reservation model class:
 * This is how the Reservation is represented
 * in the entire app.
 */
data class Reservation(
val id: Int,
val startDate: Date,
val endDate: Date,
val sessionType: String,
val trainer: String,
val sessionId: Int
)
