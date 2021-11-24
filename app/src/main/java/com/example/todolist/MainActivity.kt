package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TodoAdapter
import com.example.todolist.api.RetrofitInstance
import com.example.todolist.databinding.ActivityMainBinding
import com.example.todolist.repository.TodoRepository
import com.example.todolist.viewmodel.TodoViewModel
import com.example.todolist.viewmodel.TodoViewModelFactory

class MainActivity : AppCompatActivity() {

    private  lateinit  var binding: ActivityMainBinding
    lateinit var todoViewModel: TodoViewModel
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoViewModel = ViewModelProvider(this,TodoViewModelFactory(TodoRepository(RetrofitInstance.getInstance()))).get(TodoViewModel::class.java)

        initRecyclerView()
        observeLiveEvent()

        }

    private fun observeLiveEvent() {
        todoViewModel.todoLiveData.observe(this, Observer {
                todoList ->
            todoList?.let {
                todoAdapter.updateList(it)
            }

        }
        )
    }

    private fun initRecyclerView() {
        binding.rvTodos.layoutManager = LinearLayoutManager(this@MainActivity)
        todoAdapter = TodoAdapter()
        binding.rvTodos.adapter = todoAdapter

    }

}
