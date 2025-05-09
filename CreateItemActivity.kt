
package com.example.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class CreateItemActivity : AppCompatActivity() {

    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_item)

        titleEditText = findViewById(R.id.titleEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
        saveButton = findViewById(R.id.saveButton)

        saveButton.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()

            // Return the new item data to MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("new_item_title", title)
            resultIntent.putExtra("new_item_description", description)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}





//package com.example.todoapp
//
//import android.app.Activity
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText

/**
 * CreateItemActivity allows users to input a new Todo item.
 class CreateItemActivity : Activity() {

    private lateinit var editTitle: EditText
    private lateinit var editDescription: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_item)

        // Initialize views
        editTitle = findViewById(R.id.editTitle)
        editDescription = findViewById(R.id.editDescription)
        saveButton = findViewById(R.id.saveButton)

        // Save Button Click Listener
        saveButton.setOnClickListener {
            val title = editTitle.text.toString()
            val description = editDescription.text.toString()

            // Pass data back to MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra("new_item_title", title)
            resultIntent.putExtra("new_item_description", description)
            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }
}



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
class CreateItemActivity : AppCompatActivity() {

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
