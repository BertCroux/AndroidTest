package com.example.squads.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.squads.database.accounts.DatabaseAccount
import com.example.squads.database.accounts.AccountDao
import com.example.squads.database.measurements.DatabaseMeasurement
import com.example.squads.database.measurements.DatabaseMeasurementDao
import com.example.squads.database.reservations.*
import com.example.squads.database.sessions.Session
import com.example.squads.database.sessions.SessionDao

@Database(
    entities = [DatabaseMeasurement::class, DatabaseAccount::class, Session::class,
        DatabasePastReservation::class, DatabasePlannedReservation::class],
    version = 5, exportSchema = false
)
@androidx.room.TypeConverters(Converters::class)
abstract class SquadsRoomDatabase : RoomDatabase() {
    abstract val accountDao: AccountDao
    abstract val measurementDao: DatabaseMeasurementDao
    abstract val sessionDto: SessionDao
    abstract val pastReservationDAo: PastReservationDao
    abstract val plannedReservationDAo: PlannedReservationDao

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