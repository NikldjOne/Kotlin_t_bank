package com.example.android_t_bank.Retrofit.data.network

import retrofit2.Call
import retrofit2.http.GET
import com.example.android_t_bank.Retrofit.data.model.Post

interface ApiService {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}

