package com.example.squads.screens.sessions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.squads.R
import com.example.squads.databinding.FragmentSessionsBinding

class SessionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentSessionsBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_sessions, container, false
        )

        //get the viewmodel
        val sessionViewModel: SessionViewModel by activityViewModels()
        // set the viewmodel in the xml file
        binding.sessionViewModel = sessionViewModel

        //makes the live data work ig
        binding.lifecycleOwner = this


        val myListSessionAdapter = MyListSessionAdapter(this, sessionViewModel.weekDays, sessionViewModel.typeOfTraining, sessionViewModel.trainer)
        binding.listView.adapter = myListSessionAdapter;

        //observer on when to navigate from the graphs fragment
        sessionViewModel.navigateFromSession.observe(viewLifecycleOwner, Observer {
            //actually navigate to the graphs page
            if (it == true) {

                this.findNavController().navigate(R.id.home)
                sessionViewModel.doneNavigatingFromSession()
            }
        })

        return binding.root
    }
}