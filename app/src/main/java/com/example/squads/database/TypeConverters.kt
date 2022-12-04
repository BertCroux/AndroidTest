package com.example.squads.database

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import kotlinx.datetime.LocalDateTime
import java.time.Instant
import java.util.*

/**
 * Class for converting a string to LocalDateTime.
 */
class Converters {
    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun fromString(value: String?): Date? {
        return Date.from(Instant.parse(value))
    }

    @TypeConverter
    fun dateToString(date: Date?): String {
        return date.toString()
    }
}