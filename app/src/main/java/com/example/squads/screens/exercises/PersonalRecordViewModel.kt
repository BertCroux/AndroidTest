package com.example.squads.screens.exercises

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.squads.screens.exercises.models.PersonalRecord
import kotlinx.datetime.LocalDate

class PersonalRecordViewModel {

    //list of all personalrecords
    private val _pRecords = MutableLiveData<List<PersonalRecord>>()
    val pRecords: LiveData<List<PersonalRecord>>
        get() = _pRecords

    val _filteredRecords = MutableLiveData<List<PersonalRecord>>()

    val filteredRecords: LiveData<List<PersonalRecord>>
        get() = _filteredRecords

    init {
        getPersonalRecords()
    }

    fun getPersonalRecords() {
        _pRecords.value = listOf(
            PersonalRecord(1, 1, 1, 1, 20.0, LocalDate(2022,10,19)),
            PersonalRecord(2, 1, 1, 5, 21.0, LocalDate(2022,10,18)),
            PersonalRecord(3, 1, 1, 10, 22.0, LocalDate(2022,10,17)),
            PersonalRecord(4, 1, 2, 1, 23.0, LocalDate(2022,10,16)),
            PersonalRecord(5, 1, 2, 5, 24.0, LocalDate(2022,10,15)),
            PersonalRecord(6, 1, 2, 10, 25.0, LocalDate(2022,10,14)),
            PersonalRecord(7, 1, 4, 1, 29.0, LocalDate(2022,10,10)),
            PersonalRecord(8, 1, 4, 5, 30.0, LocalDate(2022,10,11)),
            PersonalRecord(9, 1, 5, 1, 21.0, LocalDate(2022,10,12)),
            PersonalRecord(10, 1, 5, 10, 22.0, LocalDate(2022,10,13)),
            PersonalRecord(11, 1, 6, 1, 23.0, LocalDate(2022,10,14)),
            PersonalRecord(12, 1, 6, 10, 24.0, LocalDate(2022,10,15)),
            PersonalRecord(13, 1, 7, 1, 25.0, LocalDate(2022,10,16)),
            PersonalRecord(14, 1, 7, 5, 26.0, LocalDate(2022,10,17)),
        )
    }

    fun getRecordsOfTypeAndUser(type: Int, user: Int): LiveData<List<PersonalRecord>> {
        val filtered: List<PersonalRecord> = _pRecords.value!!.filter { pr -> pr.userId == user && pr.exerciseId == type }
        _filteredRecords.value = filtered

        return filteredRecords
    }
}