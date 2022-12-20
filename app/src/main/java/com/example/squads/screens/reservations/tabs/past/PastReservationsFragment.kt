package com.example.squads.screens.reservations.tabs.past

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squads.R
import com.example.squads.databinding.FragmentPastReservationsBinding
import com.example.squads.screens.reservations.ReservationViewModel

class PastReservationsFragment : Fragment() {
    private val sharedViewModel: ReservationViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentPastReservationsBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_past_reservations, container, false
        )


        binding.pastReservationContainer2.layoutManager = LinearLayoutManager(activity)
        sharedViewModel.pastReservation.observe(viewLifecycleOwner, Observer {
            Log.d("pastreservationFragment", sharedViewModel.pastReservation.value.toString())
        })


        binding.pastReservationContainer2.adapter = PastReservationAdaptor(sharedViewModel.pastReservation)

        return binding.root
    }
}
