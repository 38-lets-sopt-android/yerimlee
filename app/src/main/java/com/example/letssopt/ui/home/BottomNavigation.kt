package com.example.letssopt.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.R




@Composable
fun BottomNavigation() {

    Row (
        modifier= Modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(Color(0xFF141414)),

        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem (
            icon= ImageVector.vectorResource(id = R.drawable.bott_1),
            label= "메인",
            selected=true
        )

        BottomNavItem(
            icon=  ImageVector.vectorResource(id= R.drawable.bott_2),
            label= "개별 구매",
            selected=false
        )

        BottomNavItem(
            icon = ImageVector.vectorResource(id = R.drawable.bott_55),
            label = "웹툰",
            selected = false
        )

        BottomNavItem (
            icon= ImageVector.vectorResource(id=R.drawable.bott_33),
            label= "찾기",
            selected= false
        )

        BottomNavItem (
            icon = ImageVector.vectorResource(id=R.drawable.bott_4),
            label= "보관함",
            selected=false
        )
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label :String,
    selected : Boolean
) {

    val color= if (selected) Color.White else Color(0xFF3A3A3A)

    Column (
        horizontalAlignment= Alignment.CenterHorizontally
    ) {

        Icon (
            imageVector= icon,
            contentDescription =label,
            tint= color,
            modifier= Modifier.size(26.dp)
        )

        Text (
            text = label,
            color= color,
            fontSize=12.sp,
            fontWeight= if (selected) FontWeight.Bold else FontWeight.Normal
        )

    }
}