package com.example.squads.database.reservations

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.squads.database.reservations.Reservation
import java.util.*

@Dao
interface ReservationDao {
    //get reservations
    //we will filter (aka map)this later in android
    @Query("SELECT * FROM reservation")
    fun getReservations(): LiveData<List<Reservation>>


    @Query("SELECT * FROM reservation WHERE :today > beginDate ")
    fun getPastReservations(today: Date): LiveData<List<Reservation>>

    @Query("SELECT * FROM reservation WHERE :today < beginDate")
    fun getPlannedReservations(today: Date): LiveData<List<Reservation>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(res: Array<Reservation>)
}