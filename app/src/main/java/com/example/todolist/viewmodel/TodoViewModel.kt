package com.example.todolist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TodoAdapter
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.model.TodoResponse
import com.example.todolist.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(private val repository: TodoRepository): ViewModel() {

    private  val _todoListLiveData=MutableLiveData<List<TodoResponse>>()
    val todoLiveData:LiveData<List<TodoResponse>>
    get() = _todoListLiveData

    fun getTodoList(){
        viewModelScope.launch {
            val result=repository.getTodos()
            if(result.isSuccessful){
                _todoListLiveData.value=result.body()
            }
            else{
                Log.i("todolist", "getTodoList: ${result.message()} ")
            }
        }

    }

}