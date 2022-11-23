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

class MyListSessionAdapter(private val dataSet: LiveData<List<Session>>, val sessionBinding : SessionListBinding) :
    RecyclerView.Adapter<MyListSessionAdapter.ViewHolder>() {

    lateinit var context : Context


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(sessionBinding.root)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.session_list, viewGroup, false)

        context = viewGroup.context

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        sessionBinding.buttonSession.setOnClickListener {
            sessionBinding.constraintLayout.background = this.context.resources.getDrawable(R.drawable.gradiant_button)
        }
        sessionBinding.constraintLayout.background = this.context.resources.getDrawable(R.drawable.gray_gradiant_button)

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        sessionBinding.workoutNameTrainer.text = "with ${dataSet.value!!.get(position).trainer}"
        sessionBinding.dateOfSession.text = dataSet.value!!.get(position).startDate.dayOfWeek.toString()
        sessionBinding.spotsleft.text = "${dataSet.value!!.get(position).spotsLeft.toString()} spots left"
        sessionBinding.workoutTypeText.text = dataSet.value!!.get(position).typeOfSession
        sessionBinding.workoutDateText.text = "${dataSet.value!!.get(position).startDate.hour}:${dataSet.value!!.get(position).startDate.minute} " +
                "${dataSet.value!!.get(position).endDate.hour}:${dataSet.value!!.get(position).endDate.minute}"

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.value!!.size

}