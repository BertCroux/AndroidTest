package com.example.squads.screens.myhealth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.squads.R
import com.example.squads.databinding.FragmentMyHealthBinding

class MyHealthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //get binding object and inflate the fragments
        val binding: FragmentMyHealthBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_my_health, container, false
        )


        //create the viewmodel
        val myHealthViewModel: MyHealthViewModel = ViewModelProvider(this).get(MyHealthViewModel::class.java)
        // set the viewmodel in the xml file
        binding.myHealthViewModel = myHealthViewModel

        //makes the live data work ig
        binding.lifecycleOwner = this


        //observers of the variables in the viewmodel
        //observer for the latest measurement
        myHealthViewModel.latestMeasurement.observe(viewLifecycleOwner, Observer { measurement ->
            //als de latestMeasurement verandert moeten alle teksten ook veranderd worden
            measurement.let {
                binding.txtWeightValue.text = String.format("%.1f", it.Weight)
                binding.txtFatValue.text = String.format("%.1f", it.FatPercentage)
                binding.txtMuscleValue.text = String.format("%.1f", it.MusclePercentage)
                binding.txtWaistCircValue.text = String.format("%.1f", it.WaistCircumference)
                //TODO BMI: moet nog lengte van persoon hebben
                binding.txtBMIValue.text = String.format("%.1f", it.Weight / (1.8*1.8))
            }
        })






        return binding.root

    }

}