package com.example.squads.screens.myhealth

import android.content.res.Resources.NotFoundException
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        addObservers()


        return binding.root
    }

    private fun addObservers() {
        //observer on when to navigate from the graphs fragment
        myHealthViewModel.navigateFromGraphs.observe(viewLifecycleOwner, Observer {
            //actually navigate to the graphs page
            if (it == true) {
                this.findNavController().navigate(R.id.action_myHealthGraphsFragment_to_myhealth)
                myHealthViewModel.doneNavigatingFromGraphs()
            }
        })

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
            "weight" -> return measurements.map { Pair(it.Weight, it.MeasuredOn) }
            "fat" -> return measurements.map { Pair(it.FatPercentage, it.MeasuredOn) }
            "muscle" -> return measurements.map { Pair(it.MusclePercentage, it.MeasuredOn) }
            "waist" -> return measurements.map { Pair(it.WaistCircumference, it.MeasuredOn) }
            "bmi" -> print("apart geval") //TODO BMIshit
            else -> {
                throw NotFoundException()
            }
        }
        throw NotFoundException()
    }

}