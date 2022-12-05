package com.example.squads.screens.exercises

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.databinding.PersonalRecordListBinding
import com.example.squads.screens.exercises.models.PersonalRecord

class PersonalRecordListAdapter(private val dataSet: LiveData<List<PersonalRecord>>?): RecyclerView.Adapter<PersonalRecordListAdapter.ViewHolder>() {

    lateinit var context: Context
    lateinit var binding:PersonalRecordListBinding
    inner class ViewHolder(val binding: PersonalRecordListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = PersonalRecordListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.prDate.text = dataSet?.value!![position].achievedOn.toString()
        binding.prWeight.text = dataSet?.value!![position].weightUsed.toString()
        binding.prReps.text = dataSet?.value!![position].amountOfReps.toString()
    }

    override fun getItemCount() = dataSet?.value?.size ?: 0

}