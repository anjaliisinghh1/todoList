package com.example.todolist.api

import com.example.todolist.model.TodoResponse
import retrofit2.Response
import retrofit2.http.GET

interface TodoAPI {

    @GET("/todos")
    suspend fun getTodos(): Response<List<TodoResponse>>
}