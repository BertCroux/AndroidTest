package com.example.squads.database

import androidx.room.TypeConverter
import kotlinx.datetime.Instant
import java.util.*

public class TypeConverters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromInstant(value: Instant): Long {
            return value.toEpochMilliseconds()
        }

        @TypeConverter
        @JvmStatic
        fun toInstant(value: Long): Instant {
            return Instant.fromEpochMilliseconds(value)
        }
    }
}