package com.example.letssopt

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit , onNavigateToSignUp: () -> Unit) {
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = "watcha",
            color = Color(0xFFE8003C),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp)
                .padding(bottom = 15.dp),
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "이메일로 로그인",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "이메일",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 8.dp)
        )

        TextField(
            value = id,
            onValueChange = { id = it },
            placeholder = { Text("이메일 주소를 입력하세요") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF1E1E1E),
                unfocusedContainerColor = Color(0xFF1E1E1E),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "비밀번호",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 8.dp)
        )

        TextField(
            value = pw,
            onValueChange = { pw = it },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text("비밀번호를 입력하세요") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF1E1E1E),
                unfocusedContainerColor = Color(0xFF1E1E1E),
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedPlaceholderColor = Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "아직 계정이 없으신가요? 회원가입",
            color = Color.Gray,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .clickable {
                    onNavigateToSignUp()
                }
        )

        Button(
            onClick = {
                saveLoginState(context)
                onLoginSuccess()
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9B1B30)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(bottom = 24.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text("로그인", fontSize = 17.sp)
        }
    }
}

fun saveLoginState(context: Context) {
    val prefs = context.getSharedPreferences("login", Context.MODE_PRIVATE)
    prefs.edit().putBoolean("isLoggedIn", true).apply()
}

fun isLoggedIn(context: Context): Boolean {
    val prefs = context.getSharedPreferences("login", Context.MODE_PRIVATE)
    return prefs.getBoolean("isLoggedIn", false)
}

@Preview
@Composable

fun LoginScreenPreview(){
    LoginScreen(
        onLoginSuccess = {},
        onNavigateToSignUp = {}
    )
}