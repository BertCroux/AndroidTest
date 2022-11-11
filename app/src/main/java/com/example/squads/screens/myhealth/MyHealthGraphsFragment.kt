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

    //the list of values to display
    lateinit var valuesForGraph: List<Pair<Double, LocalDateTime>>

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

    fun navigateBack(){
        this.findNavController().navigate(R.id.action_myHealthGraphsFragment_to_myhealth)
    }

    private fun setupSpinner() {
        //get the spinner from xml
        val spinner: Spinner = binding.spinnerHealthYears
        //create a list of items to put in the spinner
        val spinnerItems: List<String> = listOf("select", "2022", "2021", "2020")
        //create an adapter to insert the values and use a custom view (health_spinner_item) to render the items
        val spinnerAdapter = ArrayAdapter(requireActivity(), R.layout.health_spinner_item, spinnerItems)
        spinner.adapter = spinnerAdapter

        //override the onselect listeners
        spinner.onItemSelectedListener = object: OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val value = parent.getItemAtPosition(position)
                Log.i("graphs", "item selected! value: $value")
            }

            override fun onNothingSelected(p0: AdapterView<*>) {
                //do nothing...
            }
        }
    }

    private fun addObservers() {
        //get the measurements from the viewmodel
        myHealthViewModel.measurements.observe(viewLifecycleOwner, Observer {
            measurements = it
        })

        //when the button is clicked, a type is sent along with it as string and is stored in the viewmodel
        //so when the type in the viewmodel changes, the measurements have to be mapped to the right type
        // in this observer function
        myHealthViewModel.typeDataGraph.observe(viewLifecycleOwner, Observer { type ->
            Log.i("graphs", type ?: "niks")

            if (type != null) {
                valuesForGraph = mapMeasurements(type)
                valuesForGraph.forEach {
                    Log.i("graphs", it.toString())
                }
            }
        })
    }


    private fun mapMeasurements(type: String): List<Pair<Double, LocalDateTime>> {
        //this returns a list of pairs (tuples) that contain the value and the date
        when (type) {
            "Weight" -> return measurements.map { Pair(it.Weight, it.MeasuredOn) }
            "Fat" -> return measurements.map { Pair(it.FatPercentage, it.MeasuredOn) }
            "Muscle" -> return measurements.map { Pair(it.MusclePercentage, it.MeasuredOn) }
            "Waist" -> return measurements.map { Pair(it.WaistCircumference, it.MeasuredOn) }
            "BMI" -> print("apart geval") //TODO BMIshit
            else -> {
                throw NotFoundException()
            }
        }
        throw NotFoundException()
    }

}