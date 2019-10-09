package com.example.myapplication.ui.auth

import com.example.myapplication.data.db.entity.User

interface AuthListner {

    fun onStarted()

    fun onSuccess(user: User)

    fun onFailure(message: String)

}