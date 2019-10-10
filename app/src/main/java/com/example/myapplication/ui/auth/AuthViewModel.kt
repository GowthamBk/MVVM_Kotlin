package com.example.myapplication.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.myapplication.data.repositories.UserRepository
import com.example.myapplication.util.ApiException
import com.example.myapplication.util.Coroutines

class AuthViewModel(private val repository: UserRepository) : ViewModel() {

    var email: String? = null
    var password: String? = null

    var authListner: AuthListner? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonCLick(view: View) {

        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListner?.onFailure("In Valid Email or Password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListner?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListner?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListner?.onFailure(e.message!!)
            }

        }
    }

}