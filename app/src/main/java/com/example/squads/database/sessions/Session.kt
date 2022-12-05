package com.example.squads.database.sessions

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "session")
data class Session(
    @PrimaryKey
    val id: Int,
    val startDate: Date,
    val endDate: Date,
    val SessionType: String,
    val Instructor: String,
)

@RequiresApi(Build.VERSION_CODES.O)
fun List<Session>.asDomain(): List<Session> {
    return map {
        Session(
            id = it.id,
            startDate = it.startDate,
            endDate = it.endDate,
            SessionType = it.SessionType,
            Instructor = it.Instructor

        )

    }
}
