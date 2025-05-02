package com.example.myapp.domain.use_case.todo

import com.example.myapp.domain.model.Todo
import com.example.myapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodosUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    operator fun invoke(): Flow<List<Todo>> = repository.getTodos()
}
