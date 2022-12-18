package com.example.squads.network.accounts

import android.accounts.Account
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.squads.database.accounts.DatabaseAccount
import com.example.squads.database.accounts.Address
import com.example.squads.database.accounts.DatabaseReservation
import com.example.squads.database.reservations.Reservation
import com.squareup.moshi.Json
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

data class AccountDto(
    @Json(name = "id")
    var userId: Int,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phoneNumber: String,
    var address: AddressDto,
    @Json(name = "length")
    var lengthInCm: Int,
    var physicalIssues: String,
    var drugsUsed: String,
)


data class AddressDto(
    var addressLine1: String,
    var addressLine2: String,
    var zipCode: String,
    var city: String
)

data class ReservationDtoContainer(
    @Json(name = "reservations")
    val replyBody: List<ReservationDto>
)

data class ReservationDto(
    @Json(name = "id") val id: Int,
    @Json(name = "startDate") val startDate: String,
    @Json(name = "endDate") val endDate: String,
    @Json(name = "sessionType") val sessionType: String,
    @Json(name = "trainer") val trainer: String,
    @Json(name = "sessionId") val sessionId: Int
)

fun AccountDto.asDatabase(): DatabaseAccount {
    Log.d("AccountDto", this.toString())
    return DatabaseAccount(
        userId = userId,
        firstName = firstName,
        lastName = lastName,
        email = email,
        phoneNumber = phoneNumber,
        addressLine1 = address.addressLine1,
        addressLine2 = address.addressLine2,
        zipCode = address.zipCode,
        city = address.city,
        lengthInCm = lengthInCm,
        physicalIssues = physicalIssues,
        drugsUsed = drugsUsed
    )
}
fun ReservationDto.asDatabase(): DatabaseReservation {
    return DatabaseReservation(
        id = id,
        beginDate = startDate,
        endDate = endDate,
        trainerName = trainer,
        trainerType = sessionType,
        sessionId = sessionId
    )
}

@RequiresApi(Build.VERSION_CODES.O)
fun ReservationDtoContainer.asDomain(): List<com.example.squads.database.reservations.Reservation> {
    return replyBody.map {
        Reservation(
            id = it.id,
            beginDate = Date.from(Instant.parse(it.startDate)),
            endDate = Date.from(Instant.parse(it.endDate)),
            trainerName = it.trainer,
            trainerType = it.sessionType,
            sessionId = it.sessionId
            )
    }
}