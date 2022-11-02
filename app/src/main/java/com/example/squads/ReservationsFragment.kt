package com.example.squads

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class ReservationsFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        val viewPager: ViewPager = view.findViewById(R.id.view_pager)
        viewPager.adapter = ReservationsPagerAdapter(requireActivity(), parentFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservations, container, false)
    }
}