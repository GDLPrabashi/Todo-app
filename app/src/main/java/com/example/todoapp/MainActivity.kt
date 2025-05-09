package com.example.todoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.todoapp.TodoAdapter
import android.widget.Toast


/**
 * MainActivity is the entry point of the app.
 * Displays a list of Todo items using a RecyclerView.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TodoAdapter
    private val todoList = mutableListOf<Todo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //check whether item is completed or not
        adapter = TodoAdapter(todoList, { todo, isChecked ->
            todo.isCompleted = isChecked
            if (isChecked) {
                Toast.makeText(this, "${todo.title} marked as completed", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "${todo.title} marked as not completed", Toast.LENGTH_SHORT).show()
            }
        }, { todo ->
            openDetails(todo) // Call the openDetails method on item click
        })



        recyclerView.adapter = adapter

        // Load dummy data
       // loadDummyData()
        fun loadDummyData() {
            todoList.add(Todo(1, "Buy Groceries", "Milk, Bread, Eggs", false))
            todoList.add(Todo(2, "Meeting", "Discuss project with team", false))
            adapter.notifyDataSetChanged()
        }


        // Floating Action Button to Add New Item
        val fab: FloatingActionButton = findViewById(R.id.fabAddItem)
        fab.setOnClickListener {
            val intent = Intent(this, com.example.todoapp.CreateItemActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_CREATE_ITEM)
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_CREATE_ITEM && resultCode == Activity.RESULT_OK) {
            val title = data?.getStringExtra("new_item_title")
            val description = data?.getStringExtra("new_item_description")
            if (title != null && description != null) {
                // Add the new item to the list
                todoList.add(Todo(todoList.size + 1, title, description))
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE_CREATE_ITEM = 1
    }

    /**
     * Opens the details activity for the selected Todo item.
     * @param todo The selected Todo item.
     */
    private fun openDetails(todo: Todo) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("todo_title", todo.title)
        intent.putExtra("todo_description", todo.description)
        startActivity(intent)
    }

    /**
     * Loads dummy data into the list for demonstration purposes.
     */
    private fun loadDummyData() {
        todoList.add(Todo(1, "Buy Groceries", "Milk, Bread, Eggs"))
        todoList.add(Todo(2, "Meeting", "Discuss project with team"))
        adapter.notifyDataSetChanged()
    }




}
