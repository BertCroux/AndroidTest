package com.example.squads.database.accounts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class Account (
        @PrimaryKey
        val userId: Int,
        val firstName: String,
        val lastName: String,
        val email: String,
        val phoneNumber: String,
        val address: Address,
        val lengthInCm: Int,
        val physicalIssues: String,
        val drugsUsed: String,
)