package com.example.myapplication.data.network.response

import com.example.myapplication.data.db.entity.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)