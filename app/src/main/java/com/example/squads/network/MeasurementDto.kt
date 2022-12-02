package com.example.squads.network

import com.example.squads.database.measurements.DatabaseMeasurement
import com.example.squads.domain.Measurement
import com.squareup.moshi.Json
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import java.text.SimpleDateFormat

data class MeasurementDtoContainer(
    @Json(name = "body")
    val measurementDto: List<MeasurementDto>
)

data class MeasurementDto (
    @Json(name = "id")
    val id: Int,
    @Json(name = "weight")
    val weight: Double,
    @Json(name = "fatPercentage")
    val fatPercentage: Double,
    @Json(name = "musclePercentage")
    val musclePercentage: Double,
    @Json(name = "measurementDate")
    val measuredOn: String,
    @Json(name = "waistCircumference")
    val waistCircumfercence: Double,
    @Json(name = "bmi")
    val bmi: Double
)

fun MeasurementDtoContainer.asDomain(): List<Measurement> {
    return measurementDto.map {
        Measurement(
            id = it.id,
            weight = it.weight,
            fatPercentage = it.fatPercentage,
            musclePercentage = it.musclePercentage,
            waistCircumference = it.waistCircumfercence,
            measuredOn = SimpleDateFormat("dd/mm/yyyy").parse(it.measuredOn),
            bmi = it.bmi
        )
    }
}

fun MeasurementDtoContainer.asDatabase(): Array<DatabaseMeasurement> {
    return measurementDto.map {
        DatabaseMeasurement(
            id = it.id,
            weight = it.weight,
            fatPercentage = it.fatPercentage,
            musclePercentage = it.musclePercentage,
            waistCircumference = it.waistCircumfercence,
            measuredOn = SimpleDateFormat("dd/mm/yyyy").parse(it.measuredOn).toString(),
            bmi = it.bmi
        )
    }.toTypedArray()
}

fun MeasurementDto.asDatabase(): DatabaseMeasurement {
    return DatabaseMeasurement(
        id = id,
        weight = weight,
        fatPercentage = fatPercentage,
        musclePercentage = musclePercentage,
        waistCircumference = waistCircumfercence,
        measuredOn = SimpleDateFormat("dd/mm/yyyy").parse(measuredOn).toString(),
        bmi = bmi
    )
}