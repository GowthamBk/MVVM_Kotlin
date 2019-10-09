package com.example.myapplication.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repositories.UserRepository
import com.example.myapplication.util.Coroutines

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListner: AuthListner? = null

    fun onLoginButtonCLick(view: View) {

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListner?.onFailure("In Valid Email or Password")
            return
        }

        Coroutines.main {

            val response = UserRepository().userLogin(email!!, password!!)
            if (response.isSuccessful) {
                authListner?.onSuccess(response.body()?.user!!)
            } else {
                authListner?.onFailure("Error code: ${response.code()} ")
            }
        }
    }

}