package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.MainActivity
import com.example.todolist.databinding.ItemTodoBinding
import com.example.todolist.model.TodoResponse

class TodoAdapter:RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    val todos = ArrayList<TodoResponse>()

    inner class TodoViewHolder(val binding: ItemTodoBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.binding.apply {
            val todo = todos[position]
                tvTitle.text = todo.title
                cbDone.isChecked = todo.completed

        }
    }

    override fun getItemCount() = todos.size

    fun updateList(newlist : List<TodoResponse>){
        todos.clear()
        todos.addAll(newlist)

        notifyDataSetChanged()
    }

}

