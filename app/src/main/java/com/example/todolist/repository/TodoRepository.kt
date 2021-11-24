package com.example.todolist.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todolist.api.TodoAPI
import com.example.todolist.model.TodoResponse

class TodoRepository (private val todoAPI: TodoAPI){

    suspend fun getTodos()=todoAPI.getTodos()

}