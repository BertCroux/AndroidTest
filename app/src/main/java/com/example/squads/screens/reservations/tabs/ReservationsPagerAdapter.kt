package com.example.squads.screens.reservations.tabs

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ReservationsPagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PlannedReservationsFragment()
            else -> {
                PastReservationsFragment()
            }
        }
    }
}
