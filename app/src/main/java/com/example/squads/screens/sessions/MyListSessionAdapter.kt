package com.example.squads.screens.sessions

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.R
import com.example.squads.databinding.SessionListBinding
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import org.w3c.dom.Text
import java.time.format.DateTimeFormatter

class MyListSessionAdapter(private val dataSet: LiveData<List<Session>>) :
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

            viewHolder.binding.constraintLayout.background = this.context.resources.getDrawable(R.drawable.gradiant_button)
            viewHolder.binding.buttonSession.setImageResource(R.drawable.ic_cancel)

            //create new reservation => session
        }

        binding.workoutNameTrainer.text = "with ${dataSet.value!!.get(position).trainer}"
        binding.dateOfSession.text = dataSet.value!!.get(position).startDate.dayOfWeek.toString()
        binding.spotsleft.text = "${dataSet.value!!.get(position).spotsLeft.toString()} spots left"
        binding.workoutTypeText.text = dataSet.value!!.get(position).typeOfSession
        binding.workoutDateText.text = "${dataSet.value!!.get(position).startDate.hour}:${dataSet.value!!.get(position).startDate.minute} " +
                "${dataSet.value!!.get(position).endDate.hour}:${dataSet.value!!.get(position).endDate.minute}"

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.value!!.size

}