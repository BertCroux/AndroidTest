package com.example.squads.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseType(
    @PrimaryKey
    val id: Int,
    val name: String,
    val explanation: String,
    val imageUrl: String
)