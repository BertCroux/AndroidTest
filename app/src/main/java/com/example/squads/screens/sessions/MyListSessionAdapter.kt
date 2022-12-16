package com.example.squads.screens.sessions

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.R
import com.example.squads.database.sessions.Session
import com.example.squads.databinding.SessionListBinding
import java.text.SimpleDateFormat
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class MyListSessionAdapter() :
    ListAdapter<Session, MyListSessionAdapter.ViewHolder>(SessionDiffCallback()) {

    lateinit var context : Context
    lateinit var binding: SessionListBinding
    inner class ViewHolder(val binding: SessionListBinding) : RecyclerView.ViewHolder(binding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        binding = SessionListBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        context = viewGroup.context

        return ViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.binding.buttonSession.setOnClickListener {

            viewHolder.binding.constraintLayout.background = AppCompatResources.getDrawable(context, R.drawable.gradiant_button)
            viewHolder.binding.buttonSession.setImageResource(R.drawable.ic_cancel)

            //create new reservation => session
        }


        val simpleDateFormat = SimpleDateFormat("EEE dd/MM")

        val simpelTimeFormat = SimpleDateFormat("HH:mm")

        binding.workoutNameTrainer.text = context.getString(R.string.workoutnametrainer_text, getItem(position).Instructor)
        binding.dateOfSession.text = simpleDateFormat.format(getItem(position).startDate)

        binding.spotsleft.text = context.getString(R.string.spotslef_text, (6 - (getItem(position).spotsLeft)).toString())

        binding.workoutTypeText.text = getItem(position).SessionType
        binding.workoutDateText.text =
            context.getString(
                R.string.workoutdate_text
                , simpelTimeFormat.format(getItem(position).startDate)
                , simpelTimeFormat.format(getItem(position).endDate))
    }
}

class SessionDiffCallback: DiffUtil.ItemCallback<Session>() {
    override fun areItemsTheSame(oldItem: Session, newItem: Session): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Session, newItem: Session): Boolean {
        return oldItem == newItem
    }
}