package com.example.squads.network.measurements

import com.example.squads.database.measurements.DatabaseMeasurement
import com.example.squads.domain.measurements.Measurement
import com.squareup.moshi.Json
import java.text.SimpleDateFormat

data class MeasurementDtoContainer(
    @Json(name = "body")
    val replyBody: List<MeasurementDto>
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
    @Json(name = "waistCircumference")
    val waistCircumfercence: Double,
    @Json(name = "measurementDate")
    val measuredOn: String,
    //@Json(name = "bmi")
    //val bmi: Double
)

fun MeasurementDtoContainer.asDomain(): List<Measurement> {
    return replyBody.map {
        Measurement(
            id = it.id,
            weight = it.weight,
            fatPercentage = it.fatPercentage,
            musclePercentage = it.musclePercentage,
            waistCircumference = it.waistCircumfercence,
            measuredOn = SimpleDateFormat("dd/mm/yyyy").parse(it.measuredOn),
        )
    }
}

fun List<MeasurementDto>.asDatabase(): Array<DatabaseMeasurement> {
    return this.map {
        DatabaseMeasurement(
            id = it.id,
            weight = it.weight,
            fatPercentage = it.fatPercentage,
            musclePercentage = it.musclePercentage,
            waistCircumference = it.waistCircumfercence,
            measuredOn = SimpleDateFormat("dd/mm/yyyy").parse(it.measuredOn).toString(),
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
    )
}