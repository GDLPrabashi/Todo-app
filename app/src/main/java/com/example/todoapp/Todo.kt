package com.example.todoapp

data class Todo(
    val id: Int,
    val title: String,
    val description: String,
    var isCompleted: Boolean = false
)

//package com.example.todoapp
//
///**
// * Data class representing a Todo item.
// *
// * @property id Unique identifier for the Todo item.
// * @property title The title of the Todo task.
// * @property description A detailed description of the task.
// * @property isCompleted Indicates whether the task is completed (default is false).
// */
//data class Todo(
//    val id: Int,             // Unique ID for the task
//    val title: String,       // Title of the task
//    val description: String, // Description of the task
//    var isCompleted: Boolean = false // Completion status (default is false)
//)
