package com.example.letssopt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.Background
import com.example.letssopt.ui.theme.Black
import com.example.letssopt.ui.theme.Gray
import com.example.letssopt.ui.theme.GrayLight
import com.example.letssopt.ui.theme.White

@Composable
fun MainScreen() {
    Scaffold(
        bottomBar = { BottomBar() },
        containerColor = Background
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Background),
            contentPadding = PaddingValues(
                top = innerPadding.calculateTopPadding(),
                bottom = innerPadding.calculateBottomPadding() + 24.dp
            )
        ) {
            item { TopBar() }
            item { TitleSection() }
            item { BannerRow() }

            item { SectionTitle("왓고리즘") }
            item { ContentRow() }

            item { SectionTitle("공개 예정 콘텐츠") }
            item { ContentRow() }

            item { SectionTitle("왓차 파티") }
            item { PartyRow() }
        }
    }
}

@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(end = 24.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
            Text("\uD83D\uDCF9", fontSize = 22.sp, color = White)
            Text("\uD83D\uDD14", fontSize = 22.sp, color = White)
            Text("\uD83D\uDC64", fontSize = 22.sp, color = White)
        }
    }
}

@Composable
fun TitleSection() {
    Column(modifier = Modifier.padding(start = 20.dp, top = 12.dp)) {
        Text(
            text = "방금 막 도착한 신상 콘텐츠",
            color = White,
            fontSize = 20.sp,
            modifier = Modifier.height(24.dp)
        )
        Text(
            text = "예능부터 드라마까지!",
            color = Gray,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(top = 4.dp)
                .height(21.dp)
        )
    }
}

@Composable
fun BannerRow() {
    val bannerImages = listOf(
        R.drawable.img_home_newcontent_2,
        R.drawable.img_home_1,
        R.drawable.img_home_3
    )

    LazyRow(
        modifier = Modifier.padding(top = 16.dp),
        contentPadding = PaddingValues(start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(bannerImages.size) { index ->
            Image(
                painter = painterResource(id = bannerImages[index]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 300.dp, height = 160.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }
    }
}

@Composable
fun ContentRow() {
    val contentImages = listOf(
        R.drawable.img_home_1,
        R.drawable.img_home_2,
        R.drawable.img_home_3
    )

    LazyRow(
        modifier = Modifier.padding(top = 12.dp),
        contentPadding = PaddingValues(start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(contentImages.size) { index ->
            Image(
                painter = painterResource(id = contentImages[index]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 100.dp, height = 150.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
        }
    }
}

@Composable
fun PartyRow() {
    val partyImages = listOf(
        R.drawable.img_home_party_1,
        R.drawable.img_home_party_2
    )

    LazyRow(
        modifier = Modifier.padding(top = 12.dp),
        contentPadding = PaddingValues(start = 20.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(partyImages.size) { index ->
            Image(
                painter = painterResource(id = partyImages[index]),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(width = 196.dp, height = 185.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 28.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = title, color = White, fontSize = 22.sp)
        Text(
            text = "더보기",
            color = GrayLight,
            fontSize = 12.sp
        )
    }
}

@Composable
fun BottomBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Black)
            .padding(vertical = 14.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text("W\n메인", color = White, fontSize = 13.sp)
        Text("▦\n개별구매", color = Gray, fontSize = 12.sp)
        Text("▭\n웹툰", color = Gray, fontSize = 12.sp)
        Text("○\n찾기", color = Gray, fontSize = 12.sp)
        Text("□\n보관함", color = Gray, fontSize = 12.sp)
    }
}