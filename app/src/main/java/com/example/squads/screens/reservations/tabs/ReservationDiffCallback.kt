package com.example.squads.screens.reservations.tabs

import androidx.recyclerview.widget.DiffUtil
import com.example.squads.database.reservations.PastReservation

class ReservationDiffCallback: DiffUtil.ItemCallback<PastReservation>() {
    override fun areItemsTheSame(oldItem: PastReservation, newItem: PastReservation): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PastReservation, newItem: PastReservation): Boolean {
        return oldItem == newItem
    }

}
