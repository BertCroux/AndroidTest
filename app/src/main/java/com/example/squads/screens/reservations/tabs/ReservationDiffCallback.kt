package com.example.squads.screens.reservations.tabs

import androidx.recyclerview.widget.DiffUtil
import com.example.squads.database.reservations.DatabasePastReservation

class ReservationDiffCallback: DiffUtil.ItemCallback<DatabasePastReservation>() {
    override fun areItemsTheSame(oldItem: DatabasePastReservation, newItem: DatabasePastReservation): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: DatabasePastReservation, newItem: DatabasePastReservation): Boolean {
        return oldItem == newItem
    }

}
