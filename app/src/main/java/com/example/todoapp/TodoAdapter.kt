package com.example.todoapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.Todo



class TodoAdapter(
    private val todoList: List<Todo>,
    private val onCheckChanged: (Todo, Boolean) -> Unit,
    private val onItemClick: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.todoTitle)
        val description: TextView = itemView.findViewById(R.id.todoDescription)
        val checkBox: CheckBox = itemView.findViewById(R.id.markAsCompletedCheckBox)

        init {
            itemView.setOnClickListener {
                onItemClick(todoList[adapterPosition]) // Trigger the onItemClick when item is clicked
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false) // Assuming the layout file is named `todo_item.xml`
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = todoList[position]
        holder.title.text = todo.title
        holder.description.text = todo.description
        holder.checkBox.isChecked = todo.isCompleted // Update checkbox state

        // Handle checkbox state changes
        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            onCheckChanged(todo, isChecked)
        }
    }

    override fun getItemCount(): Int = todoList.size
}




//package com.example.todoapp
//import com.example.todoapp.R
//
//import android.widget.Button
//import android.graphics.Paint
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class TodoAdapter(
//    private val todoList: List<Todo>,
//    private val onItemClick: (Todo) -> Unit
//) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
//
//    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val title: TextView = itemView.findViewById(R.id.todoTitle)
//        val description: TextView = itemView.findViewById(R.id.todoDescription)
//        val markAsCompletedButton: Button = itemView.findViewById(R.id.markAsCompletedButton)
//
//        init {
//            // Handle item clicks
//            itemView.setOnClickListener {
//                onItemClick(todoList[adapterPosition])
//            }
//
//            // Handle "Mark as Completed" button clicks
//            markAsCompletedButton.setOnClickListener {
//                val todo = todoList[adapterPosition]
//                todo.isCompleted = !todo.isCompleted // Toggle completion status
//                notifyItemChanged(adapterPosition)  // Refresh the item
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
//        return TodoViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        val todo = todoList[position]
//        holder.title.text = todo.title
//        holder.description.text = todo.description
//
//        // Apply strikethrough if completed
//        if (todo.isCompleted) {
//            holder.title.paintFlags = holder.title.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
//            holder.markAsCompletedButton.text = "Undo" // Change button text
//        } else {
//            holder.title.paintFlags = holder.title.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
//            holder.markAsCompletedButton.text = "Mark as Completed"
//        }
//    }
//
//    override fun getItemCount(): Int = todoList.size
//}




//class TodoAdapter(
//    private val todoList: List<Todo>,
//    private val onItemClicked: (Todo) -> Unit
//) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
//
//    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val titleTextView: TextView = itemView.findViewById(R.id.todoTitle)
//        val descriptionTextView: TextView = itemView.findViewById(R.id.todoDescription)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_todo, parent, false)
//        return TodoViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        val todo = todoList[position]
//        holder.titleTextView.text = todo.title
//        holder.descriptionTextView.text = todo.description
//        holder.itemView.setOnClickListener {
//            onItemClicked(todo)
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return todoList.size
//    }
//}
