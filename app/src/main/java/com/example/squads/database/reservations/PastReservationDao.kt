package com.example.squads.database.reservations

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PastReservationDao {
    @Query("SELECT * FROM past_reservation")
    fun getPastReservation(): LiveData<List<PastReservation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: Array<PastReservation>)

}