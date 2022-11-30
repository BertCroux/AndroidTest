package com.example.squads.screens.exercises

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.squads.R
import com.example.squads.databinding.FragmentExercisesBinding
import com.example.squads.screens.exercises.tabs.ExercisesPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ExercisesFragment : Fragment() {

    lateinit var exerciseVM: ExercisesViewModel
    lateinit var binding: FragmentExercisesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercises, container, false)

        //set View model
        val vm: ExercisesViewModel by activityViewModels()
        exerciseVM = vm
        binding.exercisesVM = exerciseVM

        //set tabs and pageradapter
        binding.exercisePager.adapter = ExercisesPagerAdapter(exerciseVM, this)
        TabLayoutMediator(binding.exerciseTabLayout, binding.exercisePager) {tab, position ->
            tab.text = exerciseVM.exercises.value?.get(position)?.name
        }.attach()

        binding.lifecycleOwner = this

        return binding.root
    }
}