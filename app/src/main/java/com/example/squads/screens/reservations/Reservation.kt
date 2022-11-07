package com.example.squads.screens.reservations

import kotlinx.datetime.LocalDateTime
import java.time.LocalDate
import java.util.Date

data class Reservation(val beginDate: LocalDateTime, val endDate: LocalDateTime,
                       val trainerType: String, val trainerName: String)