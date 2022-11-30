package com.example.squads.screens.exercises

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.squads.R
import com.example.squads.databinding.FragmentPersonalRecordBinding
import com.example.squads.screens.exercises.models.PersonalRecord

class PersonalRecordFragment(val personalRecord: PersonalRecord) : Fragment() {

    lateinit var binding: FragmentPersonalRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_personal_record, container, false)

        binding.prWeight.text = personalRecord.weightUsed.toString()
        binding.prDate.text = personalRecord.achievedOn.toString()
        binding.prReps.text = personalRecord.amountOfReps.toString()

        // Inflate the layout for this fragment
        return binding.root
    }
}