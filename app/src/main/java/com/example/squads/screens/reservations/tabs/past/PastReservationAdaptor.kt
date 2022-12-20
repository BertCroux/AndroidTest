package com.example.squads.screens.reservations.tabs.past

import android.content.Context
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import android.view.LayoutInflater
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.R
import com.example.squads.databinding.PastReservationBinding
import com.example.squads.database.reservations.Reservation
import java.text.SimpleDateFormat

class PastReservationAdaptor() :
    ListAdapter<Reservation, PastReservationAdaptor.ViewHolder>(ReservationDiffCallback()) {
    lateinit var binding: PastReservationBinding
    lateinit var context : Context
    inner class ViewHolder(val binding: PastReservationBinding) : RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        binding = PastReservationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        context = viewGroup.context

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val simpleDateFormat = SimpleDateFormat("EEE dd/MM")
        val simpleTimeFormat = SimpleDateFormat("HH:mm")

        binding.textView3.text = getItem(position).sessionType
        binding.textView2.text = "test"

        /*

        binding.textView3.text = dataSet?.value!![position].trainerName
        binding.textView2.text = context.getString(R.string.past_reservation_text,
            dataSet.value!![position].beginDate.dayOfMonth,
        dataSet.value!![position].beginDate.monthNumber,
        dataSet.value!![position].beginDate.year)

        //binding.textView3.text = context.getString(R.string., dataSet?.value!![position].trainerName)
        binding.textView2.text = simpleDateFormat.format(dataSet?.value!![position].beginDate)


        binding.spotsleft.text = context.getString(R.string.spotslef_text, (6 - (getItem(position).spotsLeft)).toString())

        binding.workoutTypeText.text = getItem(position).SessionType
        binding.workoutDateText.text =
            context.getString(
                R.string.workoutdate_text
                , simpelTimeFormat.format(getItem(position).startDate)
                , simpelTimeFormat.format(getItem(position).endDate))
         */
    }

}
class ReservationDiffCallback: DiffUtil.ItemCallback<Reservation>() {
    override fun areItemsTheSame(oldItem: Reservation, newItem: Reservation): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Reservation, newItem: Reservation): Boolean {
        return oldItem == newItem
    }

}
