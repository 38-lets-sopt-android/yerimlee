package com.example.letssopt.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun HomeScreen(

    modifier : Modifier =  Modifier,
    viewModel : HomeViewModel= viewModel()
) {

    Column(
        modifier= modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {

        HomeTopBar()

        LazyColumn(
            modifier= Modifier.weight(1f)
        )
        {
            item  {
                Text (
                    text= "방금 막 도착한 신상 콘텐츠",
                    color= Color.White,
                    fontSize=20.sp,
                    fontWeight= FontWeight.Bold,
                    modifier= Modifier.padding(start= 19.dp, top =16.dp )
                )
        }

            item {
                Text (
                    text ="예능부터 드라마까지!",
                    color= Color (0xFFBABAC1),
                    fontSize= 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier= Modifier.padding(start= 19.dp, top= 4.dp)
                )
            }

            item{
                BannerRow(banners= viewModel.banners)
            }

            items (viewModel.sections) {
                content -> MovieSection (content  =content)
            }
        }

        BottomNavigation()
    }

}



