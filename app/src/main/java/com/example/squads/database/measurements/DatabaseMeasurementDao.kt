package com.example.squads.database.measurements

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DatabaseMeasurementDao {
    @Query("SELECT * FROM measurement")
    fun getAllMeasurements(): LiveData<List<DatabaseMeasurement>>

    @Query("SELECT * FROM measurement ORDER BY measuredOn DESC LIMIT 1")
    fun getLatestMeasurement(): DatabaseMeasurement

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(measurement: DatabaseMeasurement)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(vararg measurements: DatabaseMeasurement)
}