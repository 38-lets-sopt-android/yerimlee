package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WatchaLoginScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LoginTextField (isPassword: Boolean = false) {

    var text by remember {mutableStateOf("")}
    TextField (
        value= text,
        onValueChange = {text = it },
        visualTransformation = if(isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Composable
fun WatchaLoginScreen(modifier: Modifier = Modifier) {

    val context = LocalContext.current
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
            .statusBarsPadding()
    ) {

        Text (text = "watcha", color= Color.Red)
        Text (text ="이메일로 로그인", color = Color.White)
        LoginTextField(isPassword=false)
        LoginTextField(isPassword = true)
        Text (

            text = "아직 계정이 없으신가요 ? 회원가입",
            color= Color.White,
            modifier= Modifier.clickable {

                val intent = Intent(context, RegisterActivity::class.java)
                context.startActivity(intent)
            }
        )

        Button(onClick ={}) {

            Text (text ="로그인")
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LETSSOPTTheme {
        WatchaLoginScreen()
    }
}