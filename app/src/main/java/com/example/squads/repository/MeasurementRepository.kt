package com.example.squads.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.database.measurements.DatabaseMeasurement
import com.example.squads.database.measurements.asDomain
import com.example.squads.domain.Measurement
import com.example.squads.network.MeasurementApi
import com.example.squads.network.MeasurementDto
import com.example.squads.network.asDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MeasurementRepository(private val database: SquadsRoomDatabase) {
    val allMeasurements = Transformations.map(database.measurementDao.getAllMeasurements()) {
        it.asDomain()
    }


    val latest = Transformations.map(database.measurementDao.getLatestMeasurement()) {
        it.asDomain()
    }.value

    //val latestMeasurement = database.measurementDao.getLatestMeasurement().asDomain()

    suspend fun refreshMeasurements() {
        withContext(Dispatchers.Default) {
            val measurements = MeasurementApi.retrofitService.getAllMeasurementsFromUser(1).await()
            database.measurementDao.insertAll(*measurements.asDatabase())
        }
    }
}