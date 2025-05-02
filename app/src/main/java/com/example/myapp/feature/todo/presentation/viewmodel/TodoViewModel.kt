package com.example.myapp.feature.todo.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.domain.model.RemoteTodo
import com.example.myapp.domain.model.Todo
import com.example.myapp.domain.use_case.todo.FetchRemoteTodosUseCase
import com.example.myapp.domain.use_case.todo.GetTodosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getTodosUseCase: GetTodosUseCase,
    private val fetchRemoteTodosUseCase: FetchRemoteTodosUseCase
) : ViewModel() {

    val localTodos = getTodosUseCase().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _remoteTodos = mutableStateListOf<RemoteTodo>()
    val remoteTodos: List<RemoteTodo> = _remoteTodos

    fun fetchRemoteTodos() {
        Log.d("ansell", "fetchRemoteTodos: starting broski")
        viewModelScope.launch {
            try {
                Log.d("ansell", "fetchRemoteTodos: inside try broski")
                val result = fetchRemoteTodosUseCase()
                Log.d("ansell", "fetchRemoteTodos: got result bruh = ${result.size}")
                _remoteTodos.clear()
                _remoteTodos.addAll(result.take(10)) // Limit for demo

            } catch (e: Exception) {
                Log.d("ansell", "fetchRemoteTodos: error broski" )
                Log.e("TodoViewModel", "Failed to fetch remote todos", e)
            }
        }
    }
}