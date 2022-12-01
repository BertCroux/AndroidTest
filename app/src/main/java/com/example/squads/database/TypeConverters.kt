package com.example.squads.database

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDateTime
import java.util.*

public class TypeConverters {
    @TypeConverter
    fun toDate(dateString: String?): LocalDateTime? {
        return if (dateString == null) {
            null
        } else {
            LocalDateTime.parse(dateString)
        }
    }

    @TypeConverter
    fun toDateString(date: LocalDateTime?): String? {
        return if (date == null) {
            null
        } else {
            date.toString()
        }
    }
}