package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            LETSSOPTTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    Login( modifier= Modifier.padding(innerPadding))
                }
            }
        }
    }
}

//로그인 화면
@Composable
fun Login(
    modifier: Modifier = Modifier,
    onSignUpClick : () -> Unit= {}
) {
    var email by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    val context = LocalContext.current

    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Color(0xFF111111))
            .padding(20.dp) ,

        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "watcha" ,
            color= Color (0xFFE8003C),
            fontSize=36.sp,
            fontWeight= FontWeight.Bold ,
            modifier= Modifier.padding (top=60.dp)
        )

        Spacer ( modifier= Modifier.height(26.dp))


        Text (
            text= "이메일로 로그인",
            color=Color(0xFFFFFFFF) ,
            fontSize= 20.sp,
            fontWeight= FontWeight.Bold,
            modifier= Modifier.align(Alignment.Start)

        )

        Spacer (modifier= Modifier.height(36.dp))

        Text (
            text= "이메일",
            color=Color.Gray,
            fontSize= 14.sp,
            modifier=Modifier.align(Alignment.Start)

        )

        Spacer (modifier= Modifier.height(3.dp))

        TextField(
            value= email,
            onValueChange = { email = it},
            modifier= Modifier
                .fillMaxWidth()
                .height(52.dp),
            placeholder = {Text ("이메일 주소를 입력하세요")},
            shape= RoundedCornerShape(8.dp) ,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor= Color.White,
                unfocusedTextColor= Color.White,
                focusedPlaceholderColor= Color.Gray,
                unfocusedPlaceholderColor = Color.Gray

            )
        )

        Spacer (modifier= Modifier.height(18.dp))

        Text (
            text= "비밀번호",
            color=Color.Gray,
            fontSize= 14.sp,
            modifier=Modifier.align(Alignment.Start)

        )

        Spacer (modifier= Modifier.height(3.dp))

        TextField(
            value= password ,
            onValueChange = { password = it},
            modifier= Modifier
                .fillMaxWidth()
                .height(52.dp),
            placeholder = {Text ("비밀번호를 입력하세요")},
            shape= RoundedCornerShape(8.dp) ,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedTextColor= Color.White,
                unfocusedTextColor= Color.White,
                focusedPlaceholderColor= Color.Gray,
                unfocusedPlaceholderColor = Color.Gray
            )
        )


        Spacer(modifier= Modifier.weight(1f))


        Row  {

            Text (
                text= "아직 계정이 없으신가요? 회원가입",
                color= Color.Gray,
                fontSize=14.sp,
                modifier= Modifier.clickable {
                    val intent = Intent(context, SignUpActivity::class.java)
                    context.startActivity(intent)
                }
            )
        }

        Spacer (modifier= Modifier.height(20.dp))

        Button (
            onClick= {},
            modifier= Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors= ButtonDefaults.buttonColors(
                containerColor= Color(0xFFE8003C)
            ),
            shape= RoundedCornerShape(8.dp))

        {
            Text(
                text= "로그인",
                fontSize=16.sp,
                fontWeight= FontWeight.Bold
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LETSSOPTTheme {
        Login()
    }
}