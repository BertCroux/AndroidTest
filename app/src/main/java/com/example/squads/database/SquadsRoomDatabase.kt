package com.example.squads.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.squads.database.accounts.Account
import com.example.squads.database.accounts.AccountDao
import com.example.squads.database.exercises.Exercise
import com.example.squads.database.exercises.ExerciseDao
import com.example.squads.database.measurements.Measurement
import com.example.squads.database.measurements.MeasurementDao
import com.example.squads.database.personalrecords.PersonalRecord
import com.example.squads.database.personalrecords.PersonalRecordDao
import com.example.squads.database.reservations.Reservation
import com.example.squads.database.reservations.ReservationDao

@Database(entities = arrayOf(Account::class, Exercise::class, Measurement::class, PersonalRecord::class, Reservation::class), version = 1, exportSchema = false)
public abstract class SquadsRoomDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun measurementDao(): MeasurementDao
    abstract fun personalRecordDao(): PersonalRecordDao
    abstract fun reservationDao(): ReservationDao

    companion object {
        @Volatile
        private var INSTANCE: SquadsRoomDatabase? = null

        fun getDatabase(context: Context): SquadsRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SquadsRoomDatabase::class.java,
                    "squads_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}