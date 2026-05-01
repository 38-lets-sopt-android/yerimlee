package com.example.letssopt.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieSection (
    content: Contents
) {

    Column(
        modifier= Modifier.padding(top=24.dp)
    ) {

        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal=19.dp),
            horizontalArrangement= Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            
            if (content.titleImage != null) {
                
                Image (
                    painter=painterResource(id=content.titleImage),
                    contentDescription=null,
                    modifier=Modifier.height(22.dp)
                )
            }
            else {
                Text (
                    text = content.title ?: "",
                    color= Color.White,
                    fontSize= 18.sp,
                    fontWeight= FontWeight.Bold
                )
            }

            Text (
                text= "더보기",
                color=Color(0xFF999999),
                fontSize=12.sp
            )
        }

        Spacer (modifier=Modifier.height(8.dp))

        LazyRow(
            contentPadding=PaddingValues(horizontal=19.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(content.images) {
                imageRes ->
                Image (
                    painter=painterResource(id=imageRes),
                    contentDescription = null,
                    contentScale= ContentScale.Crop,
                    modifier= Modifier
                        .width(content.imageWidth.dp)
                        .height(content.imageHeight.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
            }
        }
    }
}