package com.example.letssopt
import android.R.attr.text
import android.content.Intent
import android.os.Bundle
import android.webkit.WebSettings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.app.Activity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.letssopt.ui.theme.LETSSOPTTheme

class MainActivity : ComponentActivity() {

    var savedId by mutableStateOf("")
    var savedPw by  mutableStateOf("")

    val signUpLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                savedId = data?.getStringExtra("id") ?: ""
                savedPw = data?.getStringExtra("pw") ?: ""
            }
        }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                MyScreen()

            }
        }
    }
}


@Composable
fun MyScreen( ) {

    var id by remember {mutableStateOf("")}
    var pw by remember {mutableStateOf(value= "")}


    val context=  LocalContext.current

    Column(
        modifier= Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Text(
            text= "watcha",
            color= Color(0xFF800020),
            modifier= Modifier
                .fillMaxWidth()
                .padding (top= 70.dp)
                .padding( bottom = 15.dp),

            textAlign= TextAlign.Center ,
            fontSize=50.sp,
            fontWeight= FontWeight.Bold


        )

        Text (
            text =" 이메일로 로그인",
            color= Color.White,
            fontSize= 22.sp,
            fontWeight= FontWeight.Bold ,
            modifier=Modifier
                .padding( 15.dp)

        )

        Spacer (
            modifier= Modifier.height(30.dp)
        )

        Column {

            Text(
                text= "이메일",
                fontSize=16.sp ,
                color= Color.Gray,
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(bottom =8.dp)
            )

            TextField(
                value= id,
                onValueChange = { id = it},
                placeholder = {
                    Text ("이메일 주소를 입력하세요")
                } ,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1E1E1E),
                    unfocusedContainerColor = Color(0xFF1E1E1E),
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray ,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                ),
                shape= RoundedCornerShape(10.dp),

                modifier=Modifier.fillMaxWidth()
                    .padding(horizontal= 16.dp)
            )

            Spacer (modifier=Modifier.height (15.dp))

            Text(
                text ="비밀번호",
                fontSize=16.sp,
                color= Color.Gray,
                modifier= Modifier.fillMaxWidth()
                    .padding(horizontal= 20.dp)
                    .padding(bottom= 8.dp)
            )

            TextField(
                value=pw,
                onValueChange = {pw = it},
                visualTransformation = PasswordVisualTransformation(),
                placeholder = {
                    Text ("비밀번호를 입력하세요")
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFF1E1E1E),
                    unfocusedContainerColor = Color(0xFF1E1E1E),
                    focusedPlaceholderColor = Color.Gray,
                    unfocusedPlaceholderColor = Color.Gray ,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                ),
                shape= RoundedCornerShape(10.dp),
                modifier=Modifier.fillMaxWidth()
                    .padding (horizontal = 16.dp)
            )

        }

        Spacer (
            modifier=Modifier.weight(1f)
        )

        TextButton (
            onClick= {
                val intent = Intent(context, SignUpActivity::class.java)
                (context as MainActivity).signUpLauncher.launch(intent)
            },
            modifier=Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(0.dp)
        ) {

            Text ("아직 계정이 없으신가요? 회원가입",
                fontSize= 12.sp,
                color= Color.Gray,
            )
        }

        Button (
            onClick= {

                if ( id == (context as MainActivity).savedId &&
                    pw == (context as MainActivity).savedPw &&
                    (context as MainActivity).savedId.isNotEmpty()) {

                    Toast.makeText (context , "로그인에 성공했습니다",
                        Toast.LENGTH_SHORT).show() }
                else {


                    Toast.makeText(
                        context,
                        "아이디 또는 비밀번호가 다릅니다",
                        Toast.LENGTH_SHORT
                    ).show()


                }
            },
            shape= RoundedCornerShape(8.dp),
            colors= ButtonDefaults.buttonColors (
                containerColor= Color(0xFF9B1B30)
            ),
            modifier=Modifier
                .fillMaxWidth()
                .height (75.dp)
                .padding (bottom= 24.dp)
                .padding (horizontal = 16.dp)

        ) {

            Text ("로그인",
                fontSize = 17.sp

            )
        }


    }

}


@Preview(showBackground = true)
@Composable
fun PreviewMyScreen() {
    MyScreen()
}
