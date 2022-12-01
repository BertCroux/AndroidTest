package com.example.squads.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.squads.database.accounts.Account
import com.example.squads.database.accounts.AccountDao
import com.example.squads.database.exercises.Exercise
import com.example.squads.database.exercises.ExerciseDao
import com.example.squads.database.measurements.DatabaseMeasurement
import com.example.squads.database.measurements.DatabaseMeasurementDao
import com.example.squads.database.personalrecords.PersonalRecord
import com.example.squads.database.personalrecords.PersonalRecordDao
import com.example.squads.database.reservations.Reservation
import com.example.squads.database.reservations.ReservationDao

@Database(entities = arrayOf(DatabaseMeasurement::class), version = 1, exportSchema = false)
@androidx.room.TypeConverters(TypeConverters::class)
public abstract class SquadsRoomDatabase : RoomDatabase() {
    //abstract fun accountDao(): AccountDao
    //abstract fun exerciseDao(): ExerciseDao
    abstract val measurementDao: DatabaseMeasurementDao
    //abstract fun personalRecordDao(): PersonalRecordDao
    //abstract fun reservationDao(): ReservationDao

    companion object {
        @Volatile
        private var INSTANCE: SquadsRoomDatabase? = null

        fun getInstance(context: Context): SquadsRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SquadsRoomDatabase::class.java,
                        "squadsDb"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}