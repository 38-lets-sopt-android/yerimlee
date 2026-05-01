package com.example.letssopt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.ui.home.HomeScreen
import com.example.letssopt.ui.login.LoginScreen
import com.example.letssopt.ui.signup.SignUpScreen


@Composable
fun NavGraph(

) {

    val navController = rememberNavController()


    NavHost(
        navController= navController,
        startDestination= "login"
    ) {


        composable ("login") {
            LoginScreen(
                onMoveToSignup= {
                    navController.navigate("signup")
                },

                onMoveToHome = {
                    navController.navigate("home")
                }
            )
        }

        composable ("signup") {
            SignUpScreen (
                onMoveToLogin= {
                    navController.popBackStack()
                }
            )
        }

        composable ("home") {
            HomeScreen()
        }
    }

}