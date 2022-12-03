package com.example.squads.database.measurements

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.squads.domain.measurements.Measurement
import java.text.SimpleDateFormat

@Entity(tableName = "measurement")
data class DatabaseMeasurement(
    @PrimaryKey
    val id: Int,
    val weight: Double,
    val fatPercentage: Double,
    val musclePercentage: Double,
    val waistCircumference: Double,
    val measuredOn: String,
)

fun List<DatabaseMeasurement>.asDomain(): List<Measurement> {
    return map {
        Measurement(
            id = it.id,
            weight = it.weight,
            fatPercentage = it.fatPercentage,
            musclePercentage = it.musclePercentage,
            waistCircumference = it.waistCircumference,
            measuredOn = SimpleDateFormat("dd/mm/yyyy").parse(it.measuredOn)
        )
    }
}

fun DatabaseMeasurement.asDomain(): Measurement {
    return Measurement(
        id = id,
        weight = weight,
        fatPercentage = fatPercentage,
        musclePercentage = musclePercentage,
        waistCircumference = waistCircumference,
        measuredOn = SimpleDateFormat("dd/mm/yyyy").parse(measuredOn)
    )
}