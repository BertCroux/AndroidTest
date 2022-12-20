package com.example.squads.domain.accounts

/**
 * Address model class:
 * This is how the Address is represented
 * in the entire app.
 */
data class Address (
    val addressLine1: String,
    val addressLine2: String,
    val zipCode: String,
    val city: String
)