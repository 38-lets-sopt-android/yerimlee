package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.app.Activity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpScreen()
        }
    }
}

@Composable
fun SignUpScreen() {
    var id by remember { mutableStateOf("") }
    var pw by remember { mutableStateOf(value = "") }
    var pwCheck by remember { mutableStateOf("") }
    val context = LocalContext.current
    val isSignUpEnabled = id.isNotBlank() && pw.isNotBlank() && pwCheck.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    )

    {

        Text(
            text = "watcha",
            color = Color(0xFF800020),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp)
                .padding(bottom = 15.dp),

            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold


        )

        Text(
            text = "회원가입",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(15.dp)

        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Column {

            Text(
                text = "이메일",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 8.dp)
            )

            TextField(
                value = id,
                onValueChange = { id = it },
                placeholder = {
                    Text("이메일 주소를 입력하세요")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1E1E1E),
                    unfocusedContainerColor = Color(0xFF1E1E1E),
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                ),
                shape = RoundedCornerShape(10.dp),

                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "비밀번호",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 8.dp)
            )

            TextField(
                value = pw,
                onValueChange = { pw = it },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = {
                    Text("비밀번호를 입력하세요")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1E1E1E),
                    unfocusedContainerColor = Color(0xFF1E1E1E),
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent ,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "비밀번호 확인",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom = 8.dp)
            )

            TextField(
                value = pwCheck,
                onValueChange = { pwCheck = it },
                visualTransformation = PasswordVisualTransformation(),
                placeholder = {
                    Text("비밀번호를 다시 입력하세요")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1E1E1E),
                    unfocusedContainerColor = Color(0xFF1E1E1E),
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
            )

        }

        Spacer(
            modifier = Modifier.weight(1f)
        )




        Button(
            onClick = {
                val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(id).matches()
                val isPasswordLengthValid = pw.length in 8..12

                if (!isEmailValid) {
                    Toast.makeText(context, "이메일 형식이 올바르지 않습니다", Toast.LENGTH_SHORT).show()
                } else if (!isPasswordLengthValid) {
                    Toast.makeText(context, "비밀번호는 8~12글자여야 합니다", Toast.LENGTH_SHORT).show()
                } else if (pw != pwCheck) {
                    Toast.makeText(context, "비밀번호 확인이 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "회원가입이 성공했습니다", Toast.LENGTH_SHORT).show()

                    val resultIntent = Intent().apply {
                        putExtra("id", id)
                        putExtra("pw", pw)
                    }

                    (context as Activity).setResult(Activity.RESULT_OK, resultIntent)
                    (context as Activity).finish()
                }

            },
            enabled = isSignUpEnabled,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF9B1B30),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFF5A5A5A),
                disabledContentColor = Color(0xFFCCCCCC)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(bottom = 24.dp)
                .padding(horizontal = 16.dp)

        ) {

            Text(
                "회원가입",
                fontSize = 17.sp

            )
        }

    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMyScreen2() {
    SignUpScreen()
}