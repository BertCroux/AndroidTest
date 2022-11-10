package com.example.squads.screens.myhealth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.datetime.LocalDateTime

class MyHealthViewModel : ViewModel() {
    //list of all the users measurements
    private val _measurements = MutableLiveData<List<Measurement>>()
    val measurements: LiveData<List<Measurement>>
        get() = _measurements


    //variable to display the values of the latest measurement
    private val _latestMeasurement = MutableLiveData<Measurement>()
    val latestMeasurement: LiveData<Measurement>
        get() = _latestMeasurement


    //variable so the graphsfragment knows what to display
    private val _typeDataGraph = MutableLiveData<String?>()
    val typeDataGraph: LiveData<String?>
        get() = _typeDataGraph


    init {
        getMeasurements()
        getLatestMeasurement()
    }


    //get all the measurements from the API
    fun getMeasurements() {
        //for now just add fake measurements
        _measurements.value = listOf(
            Measurement(
                71.7, 29.8, 34.1, 130.5,
                LocalDateTime(2022, 12, 1, 20, 0, 0, 0)
            ),
            Measurement(
                72.5, 30.8, 33.7,
                132.0, LocalDateTime(2022, 10, 1, 20, 0, 0, 0)
            )
        )
    }


    //set the _latestMeasurement value to the latest measurement
    fun getLatestMeasurement() {
        if (_measurements.value.isNullOrEmpty()) {
            return
        }

        //maybe in the api call: query sorted on latest:
        _latestMeasurement.value = _measurements.value!![0]


        //otherwise get the latest date en filter on that date
//        val dates = _measurements.value!!.map { it.MeasuredOn }
//        val latestDate: LocalDateTime? = dates.maxOrNull()
//
//        _latestMeasurement.value = _measurements.value!!.filter { it.MeasuredOn == latestDate }.first()
    }


    //navigation to graphs-----------------------------------------------------------------
    private val _navigateToGraphs = MutableLiveData<Boolean?>()
    val navigateToGraphs: LiveData<Boolean?>
        get() = _navigateToGraphs

    fun doneNavigatingToGraphs() {
        _navigateToGraphs.value = null
    }

    fun onNavigateToGraphs(type: String) {
        //set type so that the graphsfragment can know what to display
        _typeDataGraph.value = type

        //set the navigate to true so that the myhealth fragment knows when to navigate
        _navigateToGraphs.value = true
    }


}