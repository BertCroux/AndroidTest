package com.example.squads.database.accounts

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Query("SELECT * FROM account WHERE userId = :userId")
    fun getAccountDetails(userId: Int): Flow<DatabaseAccount>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(account: DatabaseAccount)
}