package com.example.squads.screens.sessions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.squads.screens.reservations.Reservation
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class SessionViewModel : ViewModel() {


    val _sessions = MutableLiveData<List<Session>>()
    val sessions: LiveData<List<Session>>
        get() = _sessions

    val language = arrayOf<String>("Mondag 03/10","","Java",".Net","Kotlin","Ruby","Rails","Python","Java Script","Php","Ajax","Perl","Hadoop")
    val description = arrayOf<String>(
        "C programming is considered as the base for other programming languages",
        "C++ is an object-oriented programming language.",
        "Java is a programming language and a platform.",
        ".NET is a framework which is used to develop software applications.",
        "Kotlin is a open-source programming language, used to develop Android apps and much more.",
        "Ruby is an open-source and fully object-oriented programming language.",
        "Ruby on Rails is a server-side web application development framework written in Ruby language.",
        "Python is interpreted scripting  and object-oriented programming language.",
        "JavaScript is an object-based scripting language.",
        "PHP is an interpreted language, i.e., there is no need for compilation.",
        "AJAX allows you to send and receive data asynchronously without reloading the web page.",
        "Perl is a cross-platform environment used to create network and server-side applications.",
        "Hadoop is an open source framework from Apache written in Java."
    )

    fun getSessions(){
        /*_sessions.value = listOf(
            Session(
                LocalDateTime(2022, 11, 1, 19, 0, 0, 0),
                LocalDateTime(2022, 11, 1, 12, 0, 0, 0),
                "Heavy workout", "Beast mode.", 6
            ),
            Session(
                LocalDateTime(2022, 11, 2, 19, 0, 0, 0),
                LocalDateTime(2022, 11, 2, 12, 0, 0, 0),
                "Yoga", "Hells.", 5
            )
        )*/

    }
    init {
        getSessions()
    }


    private val _navigateFromSession = MutableLiveData<Boolean?>()
    val navigateFromSession: LiveData<Boolean?>
        get() = _navigateFromSession

    fun doneNavigatingFromSession() {
        _navigateFromSession.value = null
    }

    fun onNavigateFromSession() {
        _navigateFromSession.value = true
    }


}