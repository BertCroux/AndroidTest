package com.example.squads.screens.myhealth

import android.content.res.Resources.NotFoundException
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.squads.R
import com.example.squads.databinding.FragmentMyHealthGraphsBinding
import kotlinx.datetime.LocalDateTime

class MyHealthGraphsFragment : Fragment() {

    lateinit var measurements: List<Measurement>

    lateinit var latestMeasurement: Measurement

    //the list of values to display
    lateinit var valuesForGraph: List<Pair<Double, LocalDateTime>>

    //filtered on year (gets initialised by the spinner)
    lateinit var valuesForGraphFiltered: List<Pair<Double, LocalDateTime>>

    lateinit var binding: FragmentMyHealthGraphsBinding

    lateinit var myHealthViewModel: MyHealthViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_my_health_graphs, container, false
        )

        //get the viewmodel
        val vm: MyHealthViewModel by activityViewModels()
        //set the viewmodel
        myHealthViewModel = vm
        // set the viewmodel in the xml file
        binding.myHealthViewModel = myHealthViewModel

        //makes the live data work ig
        binding.lifecycleOwner = this

        binding.myHealthGraphsFragment = this@MyHealthGraphsFragment


        addObservers()
        setupSpinner()


        return binding.root
    }

    fun navigateBack() {
        this.findNavController().navigate(R.id.action_myHealthGraphsFragment_to_myhealth)
    }

    private fun setupSpinner() {
        //get the spinner from xml
        val spinner: Spinner = binding.spinnerHealthYears
        //create a list of items to put in the spinner
        val spinnerItems: List<String> = getDistinctYearsFromMeasurements()
        //create an adapter to insert the values and use a custom view (health_spinner_item) to render the items
        val spinnerAdapter =
            ArrayAdapter(requireActivity(), R.layout.health_spinner_item, spinnerItems)
        spinner.adapter = spinnerAdapter

        //override the onselect listeners
        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent.getItemAtPosition(position)
                //kinda placeholder, always gets executed
                if (value == "select") {
                    valuesForGraphFiltered = emptyList()
                    return
                }

//                Log.i("graphs", "lijst voor filtering---------------")
//                logValuesForGraph()

                //effectief de lijst filteren
                valuesForGraphFiltered =
                    valuesForGraph.filter { it.second.year.toString() == value }

//                Log.i("graphs", "lijst na filtering---------------")
//                logValuesForGraphFiltered()
            }

            override fun onNothingSelected(p0: AdapterView<*>) {
                //do nothing...
            }
        }
    }

    private fun addObservers() {
        //get the measurements from the viewmodel
        measurements = myHealthViewModel.measurements.value ?: throw NotFoundException()
        myHealthViewModel.measurements.observe(viewLifecycleOwner, Observer {
            measurements = it
        })

        //get the latest measurement from the viewmodel
        latestMeasurement = myHealthViewModel.latestMeasurement.value ?: throw NotFoundException()
        myHealthViewModel.latestMeasurement.observe(viewLifecycleOwner, Observer {
            latestMeasurement = it
        })

        //when the button is clicked, a type is sent along with it as string and is stored in the viewmodel
        //so when the type in the viewmodel changes, the measurements have to be mapped to the right type
        // in this observer function
        valuesForGraph = emptyList()
        myHealthViewModel.typeDataGraph.observe(viewLifecycleOwner, Observer { type ->
            if (type != null) {
                //text instellen
                //change the text to display the type
                binding.txtCurrentType.text = type

                //lateinit var instellen en txt updaten
                valuesForGraph = mapMeasurements(type)
            }
        })
    }

    //get the years to display in the spinner
    private fun getDistinctYearsFromMeasurements(): List<String> {
        var list: MutableList<String> = measurements.map {
            it.measuredOn.year.toString()
        }.distinct().sorted().reversed().toMutableList()

        list.add(0, "select")

        return list
    }

    //this sets the value of the latest measurement of that type to the value
    //and returns a list of pairs (tuples) that contain the value and the date
    private fun mapMeasurements(type: String): List<Pair<Double, LocalDateTime>> {
        when (type) {
            "Weight" -> {
                binding.txtLatestValue.text = String.format("%.1f kg", latestMeasurement.weight)
                return measurements.map { Pair(it.weight, it.measuredOn) }
            }
            "Fat" -> {
                binding.txtLatestValue.text =
                    String.format("%.1f %%", latestMeasurement.fatPercentage)
                return measurements.map { Pair(it.fatPercentage, it.measuredOn) }
            }
            "Muscle" -> {
                binding.txtLatestValue.text =
                    String.format("%.1f %%", latestMeasurement.musclePercentage)
                return measurements.map { Pair(it.musclePercentage, it.measuredOn) }
            }
            "Waist" -> {
                binding.txtLatestValue.text =
                    String.format("%.1f cm", latestMeasurement.waistCircumference)
                return measurements.map { Pair(it.waistCircumference, it.measuredOn) }
            }
            "BMI" -> {
                //TODO BMIshit
                print("apart geval")
            }
            else -> {
                throw NotFoundException()
            }
        }
        throw NotFoundException()
    }


    //helperfunctions
    private fun logValuesForGraph() {
        valuesForGraph.forEach {
            Log.i("graphs", it.toString())
        }
    }
    private fun logValuesForGraphFiltered() {
        valuesForGraphFiltered.forEach {
            Log.i("graphs", it.toString())
        }
    }
}