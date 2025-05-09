package com.example.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity for creating a new Todo item.
 */


class CreateItemActivity: AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_item)

        // Initialize UI elements
        val titleEditText: EditText = findViewById(R.id.editTextTitle)
        val descriptionEditText: EditText = findViewById(R.id.editTextDescription)
        val saveButton: Button = findViewById(R.id.buttonSave)

        // Handle Save Button Click
        saveButton.setOnClickListener {
            val title = titleEditText.text.toString().trim()
            val description = descriptionEditText.text.toString().trim()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                // Create an Intent to send the new item back
                val resultIntent = Intent()
                resultIntent.putExtra("new_item_title", title)
                resultIntent.putExtra("new_item_description", description)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            } else {
                // Show validation errors (optional enhancement)
                titleEditText.error = if (title.isEmpty()) "Title is required" else null
                descriptionEditText.error =
                    if (description.isEmpty()) "Description is required" else null
            }
        }
    }
}