



package com.example.todoapp


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity for displaying details of a selected Todo item.
 */
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // Retrieve data from Intent
        val todoTitle = intent.getStringExtra("todo_title")
        val todoDescription = intent.getStringExtra("todo_description")

        // Bind data to views
        val titleTextView: TextView = findViewById(R.id.detailsTitle)
        val descriptionTextView: TextView = findViewById(R.id.detailsDescription)

        titleTextView.text = todoTitle
        descriptionTextView.text = todoDescription
    }
}
