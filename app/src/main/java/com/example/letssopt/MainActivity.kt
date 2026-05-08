package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.letssopt.ui.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {

               AppStartScreen()

            }
        }
    }
}

@Composable
fun AppStartScreen() {

    val context= LocalContext.current
    var isLoggedIn by remember { mutableStateOf(isLoggedIn(context)) }

    var showSignUpScreen by remember {
        mutableStateOf(false)
    }

    if (isLoggedIn) {

        MainScreen()

    } else {

        if (showSignUpScreen) {

            SignUpScreen()

        } else {

            LoginScreen(

                onLoginSuccess = {
                    isLoggedIn = true
                },

                onNavigateToSignUp = {
                    showSignUpScreen = true
                }
            )
        }
    }
}