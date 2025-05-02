package com.example.myapp.data.repository

import android.util.Log
import com.example.myapp.data.remote.api.RemoteTodoApi
import com.example.myapp.domain.model.RemoteTodo
import com.example.myapp.domain.repository.RemoteTodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteTodoRepositoryImpl(
    private val api: RemoteTodoApi
) : RemoteTodoRepository {
    override suspend fun fetchTodos(): List<RemoteTodo> {
        return try {
            withContext(Dispatchers.IO) {
                Log.d("ansell", "actually fetching first: swagger")
                api.getTodos().map { it.toDomain() }
            }
        } catch (e: Exception) {
            Log.d("ansell", "fetchTodos: ERROR", e)
            emptyList()
        }
    }
}
