package com.example.android_t_bank.Retrofit.data.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface OperationService {

    @GET("android_for_begginers_back_end/main/{user}.json")
    fun getOperations(
        @Path("user") user: String
    ): Call<Operations>
}