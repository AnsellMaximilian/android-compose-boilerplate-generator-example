package com.example.myapp.feature.todo.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapp.feature.todo.presentation.viewmodel.TodoViewModel

@Composable
fun TodoScreen(viewModel: TodoViewModel = hiltViewModel()) {
    val localTodos by viewModel.localTodos.collectAsState()
    val remoteTodos = viewModel.remoteTodos

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Local Todos", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        localTodos.forEach {
            Text("- ${it.title} [${if (it.isDone) "Done" else "Pending"}]")
        }

        Spacer(Modifier.height(24.dp))
        Button(onClick = {
            Log.d("ansell", "TodoScreen: hello")
            viewModel.fetchRemoteTodos()
        }) {
            Text("Fetch Remote Todos")
        }

        Spacer(Modifier.height(16.dp))
        if (remoteTodos.isNotEmpty()) {
            Text("Remote Todos", style = MaterialTheme.typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            remoteTodos.forEach {
                Text("- ${it.title} [${if (it.completed) "Done" else "Pending"}]")
            }
        }
    }
}

