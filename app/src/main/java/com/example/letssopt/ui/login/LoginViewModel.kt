package com.example.letssopt.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {


    var email by mutableStateOf ("")
        private set


    var password by mutableStateOf ("")
        private set


    var errorMessage by mutableStateOf ("")
        private set


    fun onEmailChanged (value :String) {

        email= value
    }

    fun onPasswordChanged (value :String) {

        password= value

    }

    fun login (): Boolean {

        if (email.isBlank() || password.isBlank() ) {

            errorMessage= "아이디와 비밀번호를 입력해주세요"
            return false
        }

        errorMessage = ""
        return true

    }


}