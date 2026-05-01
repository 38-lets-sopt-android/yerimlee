package com.example.letssopt.ui.home


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.letssopt.R


class HomeViewModel : ViewModel() {
    var userName by mutableStateOf( "SOPT")
        private set

    var message by mutableStateOf( "환영합니다")
        private set

    val banners =listOf (
        R.drawable.banner_1,
        R.drawable.banner_2,
        R.drawable.banner_3
    )

    val sections = listOf(
        Contents (
            titleImage=R.drawable.what,
            images= listOf (
                R.drawable.img_what_1,
                R.drawable.img_what_2,
                R.drawable.img_what_3
            ),
            imageWidth= 100,
            imageHeight= 150
        ),
            Contents (
                title = "공개 예정 콘텐츠",
                images = listOf (
                    R.drawable.img_what_1,
                    R.drawable.img_what_2,
                    R.drawable.img_what_3
            ),
            imageWidth=100,
            imageHeight=150
          )
    )
}