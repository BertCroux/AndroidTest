package com.example.squads.domain.accounts

import com.squareup.moshi.Json

data class Reservation(
val id: Int,
val startDate: String,
val endDate: String,
val sessionType: String,
val trainer: String,
val sessionId: Int
)
