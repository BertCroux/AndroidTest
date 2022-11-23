package com.example.squads.screens.sessions

import android.graphics.Color
import android.os.Build
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.squads.R
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import org.w3c.dom.Text
import java.time.format.DateTimeFormatter

class MyListSessionAdapter(private val dataSet: LiveData<List<Session>>) :
    RecyclerView.Adapter<MyListSessionAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val SessionType: TextView
        val SessionDate: TextView
        val SessionHour: TextView
        val SessionBox : ConstraintLayout

        init {
            // Define click listener for the ViewHolder's View.
            SessionType = view.findViewById(R.id.workout_type_text)
            SessionDate = view.findViewById(R.id.dateOfSession)
            SessionHour = view.findViewById(R.id.workout_date_text)
            SessionBox = view.findViewById(R.id.constraintLayout)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.session_list, viewGroup, false)



        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.SessionBox.setBackgroundColor()

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.SessionType.text = dataSet.value!!.get(position).typeOfSession
        viewHolder.SessionDate.text = dataSet.value!!.get(position).startDate.toString()
        viewHolder.SessionHour.text = dataSet.value!!.get(position).endDate.toString()



    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.value!!.size

}