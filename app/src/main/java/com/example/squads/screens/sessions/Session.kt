package com.example.squads.screens.sessions

import kotlinx.datetime.LocalDateTime

data class Session(val StartDate: LocalDateTime, val EndDate: LocalDateTime,
                       val TypeOfSession: String, val Trainer: String, val SpotsLeft: Number)