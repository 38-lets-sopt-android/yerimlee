package com.example.letssopt.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.letssopt.R




@Composable
fun HomeTopBar() {

    Row (
        modifier= Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding (
                top= 23.dp,
                end= 20.dp
            ),
        horizontalArrangement= Arrangement.End
    ) {


        Icon (
            imageVector= ImageVector.vectorResource(id= R.drawable.ic_camera),
            contentDescription = null,
            tint= Color.White,
            modifier= Modifier.size (24.dp)
            )

        Spacer (modifier=Modifier.width(14.dp))

        Icon(
            imageVector= ImageVector.vectorResource(id= R.drawable.ic_bell),
            contentDescription = null,
            tint= Color.White,
            modifier= Modifier.size (24.dp)
        )

        Spacer (modifier=Modifier.width(14.dp))

        Icon(
            imageVector= ImageVector.vectorResource(id= R.drawable.ic_profile),
            contentDescription = null,
            tint= Color.White,
            modifier= Modifier.size (24.dp)
        )
    }
}