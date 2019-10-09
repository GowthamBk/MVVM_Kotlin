package com.example.myapplication.data.repositories

import com.example.myapplication.data.network.MyApi
import com.example.myapplication.data.network.response.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
       return MyApi().userLogin(email, password)

    }

}