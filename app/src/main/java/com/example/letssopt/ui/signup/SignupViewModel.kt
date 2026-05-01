package com.example.letssopt.ui.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class SignupViewModel : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var passwordCheck by mutableStateOf("")
        private set


    fun onEmailChanged(value:String) {
        email = value
    }

    fun onPasswordChanged(value:String) {
        password= value
    }


    fun onPasswordCheckChanged (value: String) {
        passwordCheck= value
    }

    var errorMessage by mutableStateOf("")
        private set

    fun signup() : Boolean{


        if (email.isBlank() || password.isBlank() || passwordCheck.isBlank()) {

            errorMessage= "모든 값을 입력해주세요"
            return false
        }

        if (password != passwordCheck) {
            errorMessage = "비밀번호가 일치하지 않습니다"
            return false

        }

        errorMessage = ""
        return true

    }

}