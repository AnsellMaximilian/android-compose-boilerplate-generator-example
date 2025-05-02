package com.example.myapp.data.remote.api

import com.example.myapp.data.remote.dto.RemoteTodoDto
import retrofit2.http.GET

interface RemoteTodoApi {
    @GET("/todos")
    suspend fun getTodos(): List<RemoteTodoDto>
}
