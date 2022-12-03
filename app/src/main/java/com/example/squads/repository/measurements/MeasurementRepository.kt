package com.example.squads.repository.measurements

import androidx.lifecycle.Transformations
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.database.measurements.asDomain
import com.example.squads.network.measurements.MeasurementApi
import com.example.squads.network.measurements.asDatabase
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
        withContext(Dispatchers.IO) {
            val measurements = MeasurementApi.retrofitService.getAllMeasurementsFromUserAsync(1).await()
            database.measurementDao.insertAll(*measurements.asDatabase())
        }
    }
}