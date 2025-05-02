package com.example.myapp.domain.model

data class RemoteTodo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean
)
