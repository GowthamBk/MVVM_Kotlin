package com.example.myapplication.data.repositories

import com.example.myapplication.data.db.AppDataBase
import com.example.myapplication.data.db.entity.User
import com.example.myapplication.data.network.MyApi
import com.example.myapplication.data.network.SafeApiRequest
import com.example.myapplication.data.network.response.AuthResponse

class UserRepository(private val api: MyApi, private val db: AppDataBase) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)


    fun getUser() = db.getUserDao().getUser()

}