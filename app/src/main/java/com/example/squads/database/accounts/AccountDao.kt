package com.example.squads.database.accounts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AccountDao {
    @Query("SELECT * FROM account WHERE userId = :userId")
    fun getAccountDetails(userId: Int): Account

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(account: Account)
}