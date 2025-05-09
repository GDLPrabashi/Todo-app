package com.example.todolist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for displaying a list of Todo items in a RecyclerView.
 * @param todoList List of Todo items to display.
 * @param onItemClick Callback for handling item click events.
 */
class TodoAdapter(
    private val todoList: List<Todo>,
    private val onItemClick: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    /**
     * ViewHolder class for binding views in a RecyclerView item.
     * @param itemView The view representing a single item in the RecyclerView.
     */
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.todoTitle)
        val descriptionTextView: TextView = itemView.findViewById(R.id.todoDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.titleTextView.text = todo.title
        holder.descriptionTextView.text = todo.description

        // Handle item click
        holder.itemView.setOnClickListener { onItemClick(todo) }
    }

    override fun getItemCount(): Int = todoList.size
}
