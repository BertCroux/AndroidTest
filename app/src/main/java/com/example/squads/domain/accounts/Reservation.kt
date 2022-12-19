package com.example.squads.domain.accounts

import java.util.Date

data class Reservation(
val id: Int,
val startDate: Date,
val endDate: Date,
val sessionType: String,
val trainer: String,
val sessionId: Int
)
