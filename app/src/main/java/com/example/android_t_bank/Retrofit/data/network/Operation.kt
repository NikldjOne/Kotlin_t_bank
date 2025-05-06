package com.example.android_t_bank.Retrofit.data.network

import kotlinx.serialization.Serializable

@Serializable
data class Operation (
    val name: String,
    val amount: Int,
)