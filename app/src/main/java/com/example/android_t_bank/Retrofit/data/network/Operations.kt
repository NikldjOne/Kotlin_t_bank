package com.example.android_t_bank.Retrofit.data.network

import kotlinx.serialization.Serializable

@Serializable
data class Operations (
    val operation: List<Operation>
)