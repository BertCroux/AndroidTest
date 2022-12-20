package com.example.squads.screens.reservations.tabs

import androidx.recyclerview.widget.DiffUtil
import com.example.squads.database.reservations.Reservation

class ReservationDiffCallback: DiffUtil.ItemCallback<Reservation>() {
    override fun areItemsTheSame(oldItem: Reservation, newItem: Reservation): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Reservation, newItem: Reservation): Boolean {
        return oldItem == newItem
    }

}
