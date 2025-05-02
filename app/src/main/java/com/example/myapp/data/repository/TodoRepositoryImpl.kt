package com.example.myapp.data.repository

import com.example.myapp.data.local.dao.TodoDao
import com.example.myapp.data.local.entity.TodoEntity
import com.example.myapp.domain.model.Todo
import com.example.myapp.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val dao: TodoDao
) : TodoRepository {

    override fun getTodos(): Flow<List<Todo>> =
        dao.getAllTodos().map { list -> list.map { it.toDomain() } }

    override suspend fun addTodo(todo: Todo) {
        dao.insertTodo(todo.toEntity())
    }

    override suspend fun deleteTodo(todo: Todo) {
        dao.deleteTodo(todo.toEntity())
    }

    // Mapping extensions
    private fun TodoEntity.toDomain() = Todo(id, title, isDone)
    private fun Todo.toEntity() = TodoEntity(id, title, isDone)
}
