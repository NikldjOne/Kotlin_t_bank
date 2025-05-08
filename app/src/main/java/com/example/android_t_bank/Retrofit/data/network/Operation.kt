package com.example.android_t_bank.Retrofit.data.network

import kotlinx.serialization.Serializable

@Serializable
data class Operation (
    val id: Int,
    val type: String,
    val name: String,
    val amount: Int,
)