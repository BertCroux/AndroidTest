package com.example.squads.database.reservations

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
/**
 * interface that describes query operations
 * for the past reservations
 */
interface PastReservationDao {
    /**
     * get all past reservations of the current user
     */
    @Query("SELECT * FROM past_reservation")
    fun getPastReservation(): LiveData<List<DatabasePastReservation>>

    /**
     * insert an array of new past reservations
     * of the current user
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: Array<DatabasePastReservation>)

}