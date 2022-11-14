package com.example.squads.screens.sessions

import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.squads.R

class MyListSessionAdapter(private val context: SessionFragment, private val title: Array<String>, private val description: Array<String>)
    : ArrayAdapter<String>(context, R.layout.session_list, title) {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.session_list, null, true)

        val titleText = rowView.findViewById(R.id.workout_type_text) as TextView
        //val trainer = rowView.findViewById(R.id.trainer_text) as TextView
        val subtitleText = rowView.findViewById(R.id.workout_date_text) as TextView

        titleText.text = title[position]
        subtitleText.text = description[position]
        return rowView
    }


    }