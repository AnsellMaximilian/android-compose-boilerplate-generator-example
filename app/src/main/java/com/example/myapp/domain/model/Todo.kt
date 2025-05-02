package com.example.myapp.domain.model

data class Todo(
    val id: Int = 0,
    val title: String,
    val isDone: Boolean = false
)
