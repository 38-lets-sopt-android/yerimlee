package com.example.letssopt.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun LoginTextField (
    label: String,
    value : String,
    placeholder: String,
    onValueChange : (String) -> Unit
) {
    Column {
        Text(
            text = label,
            color = Color(0xFF999999),
            fontSize = 14.sp,
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .padding(bottom = 3.dp)
        )

        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0XFF2A2A2A),
                unfocusedContainerColor = Color(0XFF2A2A2A),
                focusedTextColor = Color(0XFF666666),
                unfocusedTextColor = Color(0XFF666666),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .padding(bottom = 18.dp)
        )
    }
}

@Preview
@Composable
fun LoginTextFieldPreview( ){
    LoginTextField(
        label="이메일",
        value= "",
        placeholder = "이메일 주소를 입력하세요",
        onValueChange= {}
    )
}

