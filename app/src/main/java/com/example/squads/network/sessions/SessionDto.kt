package com.example.squads.network.sessions

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.squads.database.measurements.DatabaseMeasurement
import com.example.squads.database.sessions.Session
import com.example.squads.domain.measurements.Measurement
import com.example.squads.network.measurements.MeasurementDto
import com.example.squads.network.measurements.MeasurementDtoContainer
import com.squareup.moshi.Json
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

data class SessionDtoContainer(
    @Json(name = "sessions")
    val replyBody: List<SessionDto>
)

data class SessionDto (
    @Json(name = "sessionId")
    val SessionId : Int,
    @Json(name = "startDate")
    val StartDate : String,
    @Json(name = "endDate")
    val EndDate : String,
    @Json(name = "amountOfReservations")
    val AmoutOfReservations : Int,
    @Json(name = "sessionType")
    val SessionType : String,
    @Json(name = "instructor")
    val Instructor : String,
    @Json(name = "canCancel")
    val CanCancel : Boolean,
    @Json(name = "canSignUp")
    val CanSignUp : Boolean,
)

@RequiresApi(Build.VERSION_CODES.O)
fun SessionDtoContainer.asDomain(): List<Session> {
    return replyBody.map {
        Session(
            id = it.SessionId,
            startDate = Date.from(Instant.parse(it.StartDate)),
            endDate = Date.from(Instant.parse(it.EndDate)),
            SessionType = it.SessionType,
            Instructor = it.Instructor
        )
    }
}

/**
 * "2022-11-01T00:00:00" fromat from dates
 */
@RequiresApi(Build.VERSION_CODES.O)
fun List<SessionDto>.asDatabase(): Array<Session> {
    val x = this.map {
        Session(
            id = it.SessionId,
            startDate = Date.from(LocalDateTime.parse(it.StartDate).atZone(ZoneId.systemDefault()).toInstant()),
            endDate = Date.from(LocalDateTime.parse(it.EndDate).atZone(ZoneId.systemDefault()).toInstant()),
            SessionType = it.SessionType,
            Instructor = it.Instructor
        )
    }.toTypedArray()

    //temporary logging
    x.iterator().forEach {
        Log.d("MeasurementDto", it.toString())
    }


    return x
}

