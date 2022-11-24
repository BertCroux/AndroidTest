package com.example.squads.screens.reservations.tabs.planned

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.databinding.PlannedReservationsListBinding
import com.example.squads.screens.reservations.Reservation

class PlannedReservationAdapter(private val dataSet: LiveData<List<Reservation>>) :
    RecyclerView.Adapter<PlannedReservationAdapter.ViewHolder>() {
    private lateinit var binding: PlannedReservationsListBinding

    inner class ViewHolder(view: PlannedReservationsListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        binding = PlannedReservationsListBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.
    }

    override fun getItemCount() = dataSet.value!!.size
}