package com.example.squads.screens.exercises.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.squads.R
import com.example.squads.databinding.FragmentExerciseDetailBinding
import com.example.squads.screens.exercises.models.Exercise
import com.example.squads.screens.exercises.models.PersonalRecord
import com.example.squads.screens.exercises.PersonalRecordListAdapter

class ExerciseDetailFragment(private val exercise: Exercise? = null, private val personalRecords: LiveData<List<PersonalRecord>>? = null) : Fragment() {
    lateinit var binding: FragmentExerciseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercise_detail, container, false)

        //binding.exerciseImage.setImageResource(context?.resources?.getIdentifier(exercise?.imageUrl, "drawable", context?.packageName) ?: -1)
        // TODO: use a binding adapter instead!


        binding.exerciseExplanation.text = exercise?.explanation ?: ""


        val prListAdapter = PersonalRecordListAdapter(personalRecords)
        binding.prList.adapter = prListAdapter
        binding.prList.layoutManager = LinearLayoutManager(activity)

        return binding.root
    }
}