package com.example.squads.database.measurements

import androidx.databinding.adapters.Converters
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.squads.domain.Measurement
import com.example.squads.network.MeasurementDto
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import java.util.Date

@Entity(tableName = "measurement")
data class DatabaseMeasurement(
    @PrimaryKey
    val id: Int,
    val weight: Double,
    val fatPercentage: Double,
    val musclePercentage: Double,
    val waistCircumference: Double,
    val measuredOn: LocalDateTime,
    val bmi: Double
)

fun List<DatabaseMeasurement>.asDomain(): List<Measurement> {
    return map {
        Measurement(
            id = it.id,
            weight = it.weight,
            fatPercentage = it.fatPercentage,
            musclePercentage = it.musclePercentage,
            waistCircumference = it.waistCircumference,
            measuredOn = it.measuredOn,
            bmi = it.bmi
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
        measuredOn = measuredOn,
        bmi = bmi
    )
}