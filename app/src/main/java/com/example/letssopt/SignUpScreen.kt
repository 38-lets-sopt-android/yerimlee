package com.example.letssopt

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.data.RetrofitClient
import com.example.letssopt.data.SignUpRequest
import com.example.letssopt.ui.theme.LoginTextField
import kotlinx.coroutines.launch

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
    var pw by remember { mutableStateOf("") }
    var pwCheck by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var part by remember { mutableStateOf("") }

    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "watcha",
            color = Color(0xFFE8003C),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp, bottom = 15.dp),
            textAlign = TextAlign.Center,
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "회원가입",
            color = Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        LoginTextField("아이디", id, "아이디를 입력하세요") { id = it }
        LoginTextField("비밀번호", pw, "비밀번호를 입력하세요") { pw = it }
        LoginTextField("비밀번호 확인", pwCheck, "비밀번호를 다시 입력하세요") { pwCheck = it }
        LoginTextField("이름", name, "이름을 입력하세요") { name = it }
        LoginTextField("이메일", email, "이메일을 입력하세요") { email = it }
        LoginTextField("나이", age, "나이를 입력하세요") { age = it }
        LoginTextField("파트", part, "파트를 입력하세요") { part = it }

        Button(
            onClick = {
                val ageInt = age.toIntOrNull()

                if (id.isBlank() || pw.isBlank() || pwCheck.isBlank() ||
                    name.isBlank() || email.isBlank() || age.isBlank() || part.isBlank()
                ) {
                    Toast.makeText(context, "모든 값을 입력해주세요", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(context, "이메일 형식이 올바르지 않습니다", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (pw.length !in 8..12) {
                    Toast.makeText(context, "비밀번호는 8~12글자여야 합니다", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (pw != pwCheck) {
                    Toast.makeText(context, "비밀번호 확인이 일치하지 않습니다", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                if (ageInt == null) {
                    Toast.makeText(context, "나이는 숫자로 입력해주세요", Toast.LENGTH_SHORT).show()
                    return@Button
                }

                coroutineScope.launch {

                    val response =
                        RetrofitClient.apiService.signUp(

                            SignUpRequest(
                                loginId = id,
                                password = pw,
                                name = name,
                                email = email,
                                age = ageInt,
                                part = part
                            )
                        )

                    if (response.isSuccessful) {

                        Toast.makeText(
                            context,
                            "회원가입 성공",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {

                        Toast.makeText(
                            context,
                            "회원가입 실패 ${response.code()}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8003C),
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(75.dp)
                .padding(bottom = 24.dp)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "회원가입",
                fontSize = 17.sp,
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyScreen2() {
    SignUpScreen()
}