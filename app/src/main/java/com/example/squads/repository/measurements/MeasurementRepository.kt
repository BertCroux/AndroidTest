package com.example.squads.repository.measurements

import android.util.Log
import androidx.lifecycle.Transformations
import com.example.squads.database.SquadsRoomDatabase
import com.example.squads.database.measurements.asDomain
import com.example.squads.network.measurements.MeasurementApi
import com.example.squads.network.measurements.asDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MeasurementRepository(private val database: SquadsRoomDatabase) {

    val allMeasurements = database.measurementDao.getAllMeasurements()
    val latest = database.measurementDao.getLatestMeasurement()

    /*
    val allMeasurements = Transformations.map(database.measurementDao.getAllMeasurements()) {
        Log.d("MeasurementRepository", it.toString())
        it.asDomain()
    }


    val latest = Transformations.map(database.measurementDao.getLatestMeasurement()) {
        Log.d("MeasurementRepository", it.toString())
        it.asDomain()
    }.value


     */
    //val latestMeasurement = database.measurementDao.getLatestMeasurement().asDomain()

    suspend fun refreshMeasurements() {
        withContext(Dispatchers.IO) {
            val measurements = MeasurementApi.retrofitService.getAllMeasurementsFromUserAsync(1).await()
            //database.measurementDao.insertAll(*measurements.asDatabase())
            database.measurementDao.insert(measurements.asDatabase()[0])
            //again logging purpuses
        }


    }
}