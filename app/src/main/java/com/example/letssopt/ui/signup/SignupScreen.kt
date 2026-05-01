package com.example.letssopt.ui.signup


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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.ui.login.LoginScreen


@Composable
fun SignUpScreen (
    onMoveToLogin : () -> Unit,
    viewModel : SignupViewModel = viewModel()
) {

    Column (
        modifier= Modifier
            .fillMaxSize()
            .background(Color(0xFF121212))
            .padding(24.dp, vertical = 48.dp),

        ) {
        Text ( text ="watcha",
            color = Color (0xFFE8003C),
            fontSize=36.sp,
            fontWeight= FontWeight.Bold )

        Spacer (modifier= Modifier.height(26.dp))

        Text ( text= "회원가입",
            color= Color.White,
            fontSize=20.sp,
            fontWeight= FontWeight.Bold
        )

        Spacer (modifier= Modifier.height(height=36.dp))

        Text(
            text= "이메일",
            color = Color(0xFF999999),
            fontSize= 14.sp
        )

        Spacer (modifier= Modifier.height(3.dp))

        TextField(
            value = viewModel.email,
            onValueChange = {viewModel.onEmailChanged(it)},
            placeholder= {
                Text("이메일 주소를 입력하세요")
            },
            modifier= Modifier.fillMaxWidth()
        )

        Spacer (modifier= Modifier.height(18.dp))

        Text (
            text = "비밀번호",
            color = Color(0xFF999999),
            fontSize= 14.sp
        )

        Spacer (modifier= Modifier.height(3.dp))

        TextField (
            value=viewModel.password,
            onValueChange = {viewModel.onPasswordChanged(it)},
            placeholder = {
                Text ("비밀번호를 입력하세요")
            },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer (modifier= Modifier.height(18.dp))


        Text (
            text = "비밀번호 확인",
            color = Color(0xFF999999),
            fontSize= 14.sp
        )

        Spacer (modifier= Modifier.height(3.dp))

        TextField (
            value=viewModel.passwordCheck,
            onValueChange = {viewModel.onPasswordCheckChanged(it)},
            placeholder = {
                Text ("비밀번호를 다시 입력하세요")
            },
            modifier = Modifier.fillMaxWidth()
        )


        Spacer (modifier= Modifier.weight(1f))

        Button (
            onClick= {
                if (viewModel.signup())
                { onMoveToLogin() }
            },
            modifier= Modifier
                .fillMaxWidth()
                .height(52.dp),

            shape= RoundedCornerShape(8.dp),
            colors= ButtonDefaults.buttonColors (
                containerColor= Color (0xFFE8003C)
            ) )
        {
            Text(
                text="회원가입",
                color= Color.White,
                fontWeight= FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true)

@Composable
fun SignupScreenPreview() {
    LoginScreen (
        onMoveToSignup ={},
        onMoveToHome = {},
    )
}