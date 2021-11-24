package com.example.todolist.api

import com.example.todolist.utility.CommonUtil.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    var retrofitService: TodoAPI?=null

    fun getInstance() : TodoAPI {

        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(TodoAPI::class.java)
        }
        return retrofitService!!
    }}

