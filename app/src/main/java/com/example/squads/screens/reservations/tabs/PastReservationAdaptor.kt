package com.example.squads.screens.reservations.tabs

import android.util.Log
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.databinding.PastReservationBinding
import com.example.squads.screens.reservations.Reservation
import com.example.squads.databinding.PlannedReservationBinding

class PastReservationAdaptor(private val dataSet: LiveData<List<Reservation>>) :
    RecyclerView.Adapter<PastReservationAdaptor.ViewHolder>() {

    lateinit var binding: PastReservationBinding
    inner class ViewHolder(val binding: PastReservationBinding) : RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        binding = PastReservationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {


        binding.textView3.text = "hi"
        /*
        binding.workoutNameTrainer.text = context.getString(R.string.workoutnametrainer_text, dataSet.value!![position].trainer)
        binding.dateOfSession.text = dataSet.value!![position].startDate.dayOfWeek.toString()
        binding.spotsleft.text = context.getString(R.string.spotslef_text, dataSet.value!![position].spotsLeft)
        binding.workoutTypeText.text = dataSet.value!![position].typeOfSession
        binding.workoutDateText.text = context.getString(R.string.workoutdate_text, dataSet.value!![position].startDate.hour, dataSet.value!![position].startDate.minute, dataSet.value!!.get(position).endDate.hour, dataSet.value!!.get(position).endDate.minute)

         */

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.value!!.size
}
