package com.example.squads.database.sessions

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.squads.database.measurements.DatabaseMeasurement
import com.example.squads.domain.measurements.Measurement
import kotlinx.coroutines.flow.Flow

@Dao
interface SessionDao {
    @Query("SELECT * FROM session")
    fun GetWeekOverView(): Flow<List<Session>>
}

@RequiresApi(Build.VERSION_CODES.O)
fun List<Session>.asDomain(): List<Session> {
    return map {
        Session(
            id = it.id,
            beginDate = it.beginDate,
            endDate = it.endDate,
            SessionType = it.SessionType,
            Instructor = it.Instructor

        )

    }
}