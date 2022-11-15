package com.example.squads.screens.sessions

import android.graphics.Color
import android.os.Build
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.RequiresApi
import com.example.squads.R
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.toJavaLocalDateTime
import java.time.format.DateTimeFormatter

class MyListSessionAdapter(private val context: SessionFragment, private val Date: Array<LocalDateTime>, private val typeOfSession: Array<String>, private val trainer : Array<String>)
    : ArrayAdapter<LocalDateTime>(context.requireContext(), R.layout.session_list, Date) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.session_list, null, true)


        val cardView = rowView.findViewById(R.id.constraintLayout) as View

        val DateText = rowView.findViewById(R.id.dateOfSession) as TextView
        val trainerText = rowView.findViewById(R.id.workout_type_text) as TextView
        val typeOfSessionText = rowView.findViewById(R.id.workout_date_text) as TextView

        cardView.background = this.context.resources.getDrawable(R.drawable.gray_gradiant_button)
        //DateText.setBackgroundColor(Color.BLACK)


        DateText.text = Date.get(position).toString()
        trainerText.text = trainer[position]
        typeOfSessionText.text = typeOfSession[position]

        return rowView
    }


    }