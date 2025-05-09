package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

-> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

// ViewHolder class to hold the views for each item
class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val titleTextView: TextView = itemView.findViewById(R.id.tvTitle)
    val descriptionTextView: TextView = itemView.findViewById(R.id.tvDescription)
}

// Inflate the layout for each item
override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
    return TodoViewHolder(view)
}

// Bind data to the views
override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
    val todo = todoList[position]
    holder.titleTextView.text = todo.title
    holder.descriptionTextView.text = todo.description

    // Handle item clicks
    holder.itemView.setOnClickListener {
        onItemClick(todo)
    }
}

// Return the total number of items
override fun getItemCount(): Int = todoList.size
}
