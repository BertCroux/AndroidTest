package com.example.squads.screens.exercises.tabs

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.squads.screens.exercises.ExercisesViewModel
import com.example.squads.screens.exercises.PersonalRecordViewModel
import com.example.squads.screens.exercises.models.Exercise
import com.example.squads.screens.exercises.models.PersonalRecord

class ExercisesPagerAdapter(val exercisesViewModel: ExercisesViewModel, fa: Fragment): FragmentStateAdapter(fa) {

    var personalRecordVM: PersonalRecordViewModel = PersonalRecordViewModel()

    override fun getItemCount(): Int = exercisesViewModel.exercises.value?.size ?: 0;

    override fun createFragment(position: Int): Fragment {
        val exercise: Exercise? = exercisesViewModel.exercises.value?.get(position)
        val prs: LiveData<List<PersonalRecord>> = personalRecordVM.getRecordsOfTypeAndUser(exercise?.id ?: -1, 1)
        return ExerciseDetailFragment(exercise, prs)
    }
}