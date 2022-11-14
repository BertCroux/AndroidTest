package com.example.squads.screens.sessions

import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.squads.R

class MyListSessionAdapter(private val context: SessionFragment, private val Session: LiveData<List<Session>>)
    : Adapter<List<Session>> (context, R.layout.session_list, workout_type_text) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.session_list, null, true)

        val sessionType = rowView.findViewById(R.id.workout_type_text) as TextView
        val trainer = rowView.findViewById(R.id.trainer_text) as TextView
        val hour = rowView.findViewById(R.id.workout_date_text) as TextView

        sessionType.text = Session.typeOfSession[position].toString()
        trainer.text = Session.trainer[position].toString()
        //hour.text = Session.startDate.format(DateTimeFormatter.ofPattern("HH/mm"));
        return rowView
    }

}