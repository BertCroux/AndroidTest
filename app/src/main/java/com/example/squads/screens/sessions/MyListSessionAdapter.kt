package com.example.squads.screens.sessions

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.R
import com.example.squads.database.sessions.Session
import com.example.squads.databinding.SessionListBinding

class MyListSessionAdapter(private val dataSet: LiveData<List<Session>>?) :
    RecyclerView.Adapter<MyListSessionAdapter.ViewHolder>() {

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
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {



        viewHolder.binding.buttonSession.setOnClickListener {

            viewHolder.binding.constraintLayout.background = AppCompatResources.getDrawable(context, R.drawable.gradiant_button)
            viewHolder.binding.buttonSession.setImageResource(R.drawable.ic_cancel)

            //create new reservation => session
        }

        binding.workoutNameTrainer.text = context.getString(R.string.workoutnametrainer_text, dataSet?.value!![position].Instructor)
        //binding.dateOfSession.text = dataSet.value!![position].startDate.dayOfWeek.toString()
        //binding.spotsleft.text = context.getString(R.string.spotslef_text, dataSet.value!![position]) spotsleft?
        binding.workoutTypeText.text = dataSet?.value!![position].SessionType
        //binding.workoutDateText.text = context.getString(R.string.workoutdate_text, dataSet.value!![position].startDate.hour, dataSet.value!![position].startDate.minute, dataSet.value!!.get(position).endDate.hour, dataSet.value!!.get(position).endDate.minute)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet?.value?.size ?: 0

}