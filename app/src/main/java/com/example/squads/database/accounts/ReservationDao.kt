package com.example.squads.database.accounts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ReservationDao {
    //get reservations
    //we will filter (aka map)this later in android
    @Query("SELECT * FROM reservation")
    fun getReservations(): LiveData<List<Reservation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: Reservation)
}