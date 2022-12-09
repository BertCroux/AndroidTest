package com.example.squads.repository.sessions

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.network.sessions.RequestId
import com.example.squads.network.sessions.SessionApi
import com.example.squads.network.sessions.asDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SessionRepository(private val database: SquadsRoomDatabase) {


    val allSessions = database.sessionDto.GetWeekOverView()

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun refreshSessions() {
        withContext(Dispatchers.IO) {
            val sessions = SessionApi.retrofitService.GetWeekOverView(RequestId(1)).await()
            database.sessionDto.insert(sessions.asDatabase()[0])
        }

    }
}