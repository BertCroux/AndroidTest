package com.example.squads.screens.sessions

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
import androidx.viewpager2.widget.ViewPager2
import com.example.squads.R
import com.example.squads.databinding.FragmentSessionsBinding
import com.example.squads.screens.reservations.tabs.ReservationsPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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

        //observer on when to navigate from the graphs fragment
        sessionViewModel.navigateFromSession.observe(viewLifecycleOwner, Observer {
            //actually navigate to the graphs page
            if (it == true) {
                Log.i("fromSession", "keer terug naar session")

                this.findNavController().navigate(R.id.home)
                sessionViewModel.doneNavigatingFromSession()
            }
        })

        return binding.root
    }
}