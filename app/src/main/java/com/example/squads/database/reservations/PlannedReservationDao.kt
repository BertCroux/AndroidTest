package com.example.squads.database.reservations

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
/**
 * interface that describes query operations
 * for the planned reservations
 */
interface PlannedReservationDao {
    /**
     * get all planned reservations of the current user
     */
    @Query("SELECT * FROM planned_reservation")
    fun getPlannedReservation(): LiveData<List<DatabasePlannedReservation>>

    /**
     * insert an array of new planned reservations
     * of the current user
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: Array<DatabasePlannedReservation>)
}