package com.example.letssopt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

data class Contents(
    val title: String,
    val subtitle: String? = null,
    val titleImage : Int ?= null,
    val images: List<Int>,
    val imageWidth: Int = 100,   // ← 추가
    val imageHeight: Int = 150
)

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = viewModel()
) {

    LazyColumn (
        modifier= modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        //상단바
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top= 23.dp, end = 20.dp),
                horizontalArrangement = Arrangement.End

                ) {

                Icon(
                    painter = painterResource(id = R.drawable.cam),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)

                )

                Spacer(modifier = Modifier.width(14.dp))

                Icon(
                    painter = painterResource(id = R.drawable.ring),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)

                )

                Spacer(modifier = Modifier.width(14.dp))

                Icon(
                    painter = painterResource(id = R.drawable.prof),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)

                )

            }
        }
        //제목

        item {
            Column(

                modifier = Modifier.padding(start = 19.dp)
                .padding(top=47.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            )
            {
                Text(
                    text = "방금 막 도착한 신상 컨텐츠",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.W600,
                    fontFamily = FontFamily(
                        Font(R.font.pretendard_semibold)
                    )
                )
                Text(
                    text = "예능부터 드라마까지!",
                    color = Color(0xFFBABAC1),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.pretendard_semibold))
                )


            }
        }

        //배너

        item {
            LazyRow {

                items(viewModel.banners) {

                        imageRes ->

                    Image(

                        painter = painterResource(id = imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .height(160.dp)
                    )


                }


            }
        }


        items(viewModel.sections) {
                content ->
            MovieScreen(content = content)

        }

    }

}


@Composable
fun MovieScreen(content: Contents) {
    Column(
        modifier = Modifier
            .padding(start = 8.dp)
            .padding(top = 8.dp)
    ) {
        if (content.titleImage != null) {
            Image(
                painter = painterResource(id = content.titleImage),
                contentDescription = null,
                modifier = Modifier
                    .width(80.dp)
                    .height(26.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (content.subtitle != null) {
                    Text(
                        text = content.subtitle,
                        color = Color(0xFF999999),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Text("더보기", color = Color.Gray, fontSize = 12.sp)
            }
        } else {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = content.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text("더보기", color = Color.Gray, fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(content.images) { imageRes ->
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .width(content.imageWidth.dp)
                        .height(content.imageHeight.dp)
                )
            }
        }
    }
}
