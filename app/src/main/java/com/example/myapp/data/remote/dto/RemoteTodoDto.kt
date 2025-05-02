package com.example.myapp.data.remote.dto

import com.example.myapp.domain.model.RemoteTodo
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty

data class RemoteTodoDto @JsonCreator constructor(
    @JsonProperty("userId") val userId: Int,
    @JsonProperty("id") val id: Int,
    @JsonProperty("title") val title: String,
    @JsonProperty("completed") val completed: Boolean
) {
    fun toDomain(): RemoteTodo = RemoteTodo(
        userId = userId,
        id = id,
        title = title,
        completed = completed
    )
}
