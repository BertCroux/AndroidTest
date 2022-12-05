package com.example.squads.network.sessions

import com.example.squads.network.measurements.MeasurementDto
import com.squareup.moshi.Json
import java.util.*

data class SessionDtoContainer(
    @Json(name = "body")
    val replyBody: List<SessionDto>
)

data class SessionDto (
    @Json(name = "sessionId")
    val SessionId : Number,
    @Json(name = "startDate")
    val StartDate : Date,
    @Json(name = "endDate")
    val EndDate : Date,
    @Json(name = "amoutOfReservations")
    val AmoutOfReservations : Number,
    @Json(name = "sessionType")
    val SessionType : String,
    @Json(name = "instructor")
    val Instructor : String,
    @Json(name = "canCancel")
    val CanCancel : Boolean,
    @Json(name = "canSignUp")
    val CanSignUp : Boolean,
)
