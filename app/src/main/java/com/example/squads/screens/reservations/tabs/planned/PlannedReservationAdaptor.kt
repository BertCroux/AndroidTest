package com.example.squads.screens.reservations.tabs.planned

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.R
import com.example.squads.database.reservations.Reservation
import com.example.squads.databinding.PlannedReservationBinding
import com.example.squads.screens.reservations.tabs.ReservationDiffCallback

class PlannedReservationAdaptor() :
    ListAdapter<Reservation,PlannedReservationAdaptor.ViewHolder>(ReservationDiffCallback()) {
    lateinit var context : Context

    lateinit var binding: PlannedReservationBinding
    inner class ViewHolder(val binding: PlannedReservationBinding) : RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        binding = PlannedReservationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        context = viewGroup.context

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        binding.textView3.text = getItem(position).sessionType
        binding.trainerText.text = getItem(position).trainerName
        /*
        binding.workoutDateText.text = context.getString(R.string.workoutdate_text,
            dataSet.value!![position].beginDate.hour,
            dataSet.value!![position].beginDate.minute,
            dataSet.value!![position].endDate.hour,
            dataSet.value!![position].endDate.minute,
            )
         */
    }

}
