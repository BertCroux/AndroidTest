package com.example.squads.screens.reservations.tabs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.squads.R
import com.example.squads.databinding.FragmentPlannedReservationsBinding
import com.example.squads.screens.reservations.Reservation
import com.example.squads.screens.reservations.ReservationViewModel

class PlannedReservationsFragment : Fragment() {
    private val sharedViewModel: ReservationViewModel by activityViewModels()
    private lateinit var binding: FragmentPlannedReservationsBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_planned_reservations, container, false
        )

        /*
        sharedViewModel.plannedReservation.value?.forEach {
            createReservation(it)
        }*/


        return binding.root
    }

    /**
     * create a planned reservation with the use of a layout inflater.
     * getSystemService is a method that we want to use to access LayoutInflater.
     *
     * LayoutInflater is used to 'convert' the XML into the corresponding kotlin objects.
     * @see https://developer.android.com/reference/android/content/Context
     */
    fun createReservation(reservation: Reservation) {
        val inflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val plannedReservation = inflater.inflate(R.layout.planned_reservation, null)

        // makes custom reservation based of the list in the sharedViewModel?

        binding.pastReservationContainer.addView(
            plannedReservation,
            binding.pastReservationContainer.childCount - 1
        )
    }
}
