package com.example.myapp.domain.repository

import com.example.myapp.domain.model.RemoteTodo

interface RemoteTodoRepository {
    suspend fun fetchTodos(): List<RemoteTodo>
}
