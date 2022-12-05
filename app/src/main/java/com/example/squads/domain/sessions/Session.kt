package com.example.squads.domain.sessions

import java.util.*

data class Session(
    val StartDate : Date,
    val EndDate : Date,
    val AmoutOfReservations : Int,
    val SessionType : String,
    val Instructor : String,
    val CanCancel : Boolean,
    val CanSignUp : Boolean,
    val SessionId : Int,

)
