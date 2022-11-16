package com.example.squads.screens.exercises

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ExercisesPagerAdapter(fa: Fragment, vm: ExercisesViewModel): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 7

    override fun createFragment(position: Int): Fragment {

        return ExerciseDetailFragment(ExerciseType(0,"","",""))
    }
}