package com.example.workouttracker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WorkoutsFragment : Fragment(R.layout.fragment_workouts) {

    private lateinit var adapter: ExerciseAdapter
    private lateinit var emptyTextView: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Connects the RecyclerView and empty message to the layout.
        val recyclerView =
            view.findViewById<RecyclerView>(R.id.exerciseRecyclerView)

        emptyTextView =
            view.findViewById(R.id.emptyTextView)

        val addEntryButton =
            view.findViewById<Button>(R.id.addEntryButton)

        // Sets up the list that displays all my saved workouts.
        adapter = ExerciseAdapter(emptyList())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Opens the screen where the user can enter another workout.
        addEntryButton.setOnClickListener {
            val intent = Intent(
                requireContext(),
                AddEntryActivity::class.java
            )
            startActivity(intent)
        }

        loadExercises()
    }

    override fun onResume() {
        super.onResume()

        // Reloads the list when I return from adding a workout.
        if (isAdded && view != null) {
            loadExercises()
        }
    }

    private fun loadExercises() {
        viewLifecycleOwner.lifecycleScope.launch {
            val database = ExerciseDatabase.getDatabase(requireContext())

            // Gets the saved workout entries off the main thread.
            val exercises = withContext(IO) {
                database.exerciseDao().getAllExercises()
            }

            // Updates the RecyclerView after the database finishes loading.
            adapter.updateExercises(exercises)

            if (exercises.isEmpty()) {
                emptyTextView.visibility = View.VISIBLE
            } else {
                emptyTextView.visibility = View.GONE
            }
        }
    }
}