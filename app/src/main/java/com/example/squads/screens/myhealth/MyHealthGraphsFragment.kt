package com.example.squads.screens.myhealth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.squads.R
import com.example.squads.databinding.FragmentMyHealthGraphsBinding

class MyHealthGraphsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentMyHealthGraphsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_my_health_graphs, container, false
        )

        //get the viewmodel
        val myHealthViewModel: MyHealthViewModel by activityViewModels()
        // set the viewmodel in the xml file
        binding.myHealthViewModel = myHealthViewModel

        //makes the live data work ig
        binding.lifecycleOwner = this

        //observer on when to navigate from the graphs fragment
        myHealthViewModel.navigateFromGraphs.observe(viewLifecycleOwner, Observer {
            //actually navigate to the graphs page
            if (it == true) {
                this.findNavController().navigate(R.id.action_myHealthGraphsFragment_to_myhealth)
                myHealthViewModel.doneNavigatingFromGraphs()
            }
        })

        return binding.root
    }

}