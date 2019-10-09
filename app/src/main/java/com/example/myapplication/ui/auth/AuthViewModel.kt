package com.example.myapplication.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repositories.UserRepository

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListner: AuthListner? = null

    fun onLoginButtonCLick(view: View) {

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListner?.onFailure("In Valid Email or Password")
            return
        }

        val loginResponse = UserRepository().userLogin(email!!, password!!)
        authListner?.onSuccess(loginResponse)

    }

}