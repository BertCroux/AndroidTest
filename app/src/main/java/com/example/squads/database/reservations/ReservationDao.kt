package com.example.squads.database.reservations

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.*

@Dao
interface ReservationDao {
    //get reservations
    //we will filter (aka map)this later in android
    @Query("SELECT * FROM reservation")
    fun getReservations(): LiveData<List<PastReservation>>


    @Query("SELECT * FROM reservation WHERE datetime(:today) > datetime(beginDate)")
    fun getPastReservations(today: Date): LiveData<List<PastReservation>>

    @Query("SELECT * FROM reservation WHERE datetime(:today) < datetime(beginDate)")
    fun getPlannedReservations(today: Date): LiveData<List<PastReservation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: Array<PastReservation>)
}