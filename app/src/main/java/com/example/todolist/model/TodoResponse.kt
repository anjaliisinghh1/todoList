package com.example.todolist.model


data class TodoResponse(
    val userId: Int,
    val id : Int,
    val title : String,
    val completed : Boolean)


