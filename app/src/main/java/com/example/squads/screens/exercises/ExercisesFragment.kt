package com.example.squads.screens.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.squads.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class ExercisesFragment : Fragment() {
    lateinit var viewModel: ExercisesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ExercisesViewModel()

        val tabLayout: TabLayout = view.findViewById(R.id.exercises_tabs)
        val viewPager: ViewPager2 = view.findViewById(R.id.exercises_pager)
        viewPager.adapter = ExercisesPagerAdapter(this, viewModel)
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->
            tab.text = viewModel.exercises.value?.get(position)?.name
        }.attach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercises, container, false)
    }
}