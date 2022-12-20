package com.example.squads.database.reservations

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlannedReservationDao {
    @Query("SELECT * FROM planned_reservation")
    fun getPlannedReservation(): LiveData<List<PlannedReservation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: Array<PlannedReservation>)
}