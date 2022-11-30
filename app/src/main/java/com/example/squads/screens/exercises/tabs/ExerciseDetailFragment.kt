package com.example.squads.screens.exercises.tabs

import android.graphics.Paint.Align
import android.os.Bundle
import android.text.Layout.Alignment
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Space
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintAttribute
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.squads.R
import com.example.squads.databinding.FragmentExerciseDetailBinding
import com.example.squads.screens.exercises.models.Exercise
import com.example.squads.screens.exercises.models.PersonalRecord
import kotlinx.datetime.LocalDate

class ExerciseDetailFragment(val exercise: Exercise?, val personalRecords: List<PersonalRecord>) : Fragment() {
    lateinit var binding: FragmentExerciseDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exercise_detail, container, false)

        binding.exerciseImage.setImageResource(context?.resources?.getIdentifier(exercise?.imageUrl, "drawable", context?.packageName) ?: -1)

        personalRecords.forEach { pr -> binding.exerciseRecords.addView(createRecord(pr.amountOfReps, pr.achievedOn, pr.weightUsed)) }

        return binding.root
    }

    fun createRecord(reps: Int, date: LocalDate, weight: Double): View {
        val record: View = LayoutInflater.from(context).inflate(R.layout.fragment_personal_record, null, false)
        var ll: LinearLayout = LinearLayout(context)
        ll.background = resources.getDrawable(R.drawable.gray_gradiant_button_upside_down)
        ll.orientation = LinearLayout.HORIZONTAL
        ll.setPadding(30, 30, 30, 30)

        var tv1: TextView = TextView(ll.context)
        tv1.text = reps.toString()+" reps"
        tv1.setTextColor(resources.getColor(R.color.white))
        tv1.textSize = 16F

        var tv2: TextView = TextView(ll.context)
        tv2.text = date.toString()
        tv2.setTextColor(resources.getColor(R.color.white))
        tv2.textSize = 16F

        var tv3: TextView = TextView(ll.context)
        tv3.text = weight.toString()+" kg"
        tv3.gravity = Gravity.END
        tv3.setTextColor(resources.getColor(R.color.white))
        tv3.textSize = 16F

        ll.addView(tv1)
        ll.addView(tv2)
        ll.addView(tv3)

        return ll
    }
}