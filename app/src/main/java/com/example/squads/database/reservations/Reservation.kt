package com.example.squads.database.reservations

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "reservation")
data class Reservation(
    @PrimaryKey
    val id: Int,
    val beginDate: Date,
    val endDate: Date,
    val sessionType: String,
    val trainerName: String,
    val sessionId: Int
)



@RequiresApi(Build.VERSION_CODES.O)
fun List<Reservation>.asDomain(): List<Reservation> {
    return map {
        Reservation(
            id = it.id,
            beginDate = it.beginDate,
            endDate = it.endDate,
            trainerName = it.trainerName,
            sessionType = it.sessionType,
            sessionId = it.sessionId
            )
    }
}