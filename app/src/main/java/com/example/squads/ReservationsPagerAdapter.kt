package com.example.squads

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

//TODO(update with FragmentStateAdapter (ViewPager2))
class ReservationsPagerAdapter(private val context: Context, fm: FragmentManager): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "planned"
            else -> {
                "past"
            }
        }
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> PlannedReservationsFragment()
            else -> {
                PastReservationsFragment()
            }
        }
    }
}