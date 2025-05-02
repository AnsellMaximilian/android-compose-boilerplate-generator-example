package com.example.myapp.domain.use_case.todo

import android.util.Log
import com.example.myapp.domain.model.RemoteTodo
import com.example.myapp.domain.repository.RemoteTodoRepository
import javax.inject.Inject

class FetchRemoteTodosUseCase @Inject constructor(
    private val repository: RemoteTodoRepository
) {
    suspend operator fun invoke(): List<RemoteTodo> {
        Log.d("ansell", "invoke: fetching")
        return try {
            val result = repository.fetchTodos()
            Log.d("ansell", "Fetched ${result.size} todos")
            result
        } catch (e: Exception) {
            Log.d("ansell", "invoke: error")
            emptyList()
        }
    }
}
