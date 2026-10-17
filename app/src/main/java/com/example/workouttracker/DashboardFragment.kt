package com.example.workouttracker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private lateinit var totalWorkoutsTextView: TextView
    private lateinit var averageDurationTextView: TextView
    private lateinit var averageCaloriesTextView: TextView
    private lateinit var totalCaloriesTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Connects the progress cards to the TextViews in my layout.
        totalWorkoutsTextView =
            view.findViewById(R.id.totalWorkoutsTextView)

        averageDurationTextView =
            view.findViewById(R.id.averageDurationTextView)

        averageCaloriesTextView =
            view.findViewById(R.id.averageCaloriesTextView)

        totalCaloriesTextView =
            view.findViewById(R.id.totalCaloriesTextView)
    }

    override fun onResume() {
        super.onResume()

        // Updates the statistics whenever I return to the dashboard.
        loadProgress()
    }

    private fun loadProgress() {
        viewLifecycleOwner.lifecycleScope.launch {
            val database = ExerciseDatabase.getDatabase(requireContext())

            // Reads my saved workouts on the background thread.
            val exercises = withContext(IO) {
                database.exerciseDao().getAllExercises()
            }

            // Calculates the totals using the saved workout information.
            val totalWorkouts = exercises.size
            val totalDuration = exercises.sumOf { it.duration }
            val totalCalories = exercises.sumOf { it.calories }

            val averageDuration = if (totalWorkouts > 0) {
                totalDuration / totalWorkouts
            } else {
                0
            }

            val averageCalories = if (totalWorkouts > 0) {
                totalCalories / totalWorkouts
            } else {
                0
            }

            // Displays the results on the dashboard.
            totalWorkoutsTextView.text = totalWorkouts.toString()
            averageDurationTextView.text = "$averageDuration min"
            averageCaloriesTextView.text = averageCalories.toString()
            totalCaloriesTextView.text = totalCalories.toString()
        }
    }
}