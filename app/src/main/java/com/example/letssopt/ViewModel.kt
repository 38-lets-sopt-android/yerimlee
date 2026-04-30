package com.example.letssopt

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {



    val sections = listOf (


        Contents (

            title= "왓고리즘",
            titleImage= R.drawable.textimg,
            subtitle= "예능부터 드라마까지",
            images = listOf(R.drawable.img_home_1, R.drawable.img_home_2, R.drawable.img_home_3,
                R.drawable.img_home_1, R.drawable.img_home_2, R.drawable.img_home_3),
            imageWidth=100,
            imageHeight=150
        ) ,

        Contents (
            title= "공개 예정 콘텐츠",
            images = listOf(R.drawable.img_home_1, R.drawable.img_home_2, R.drawable.img_home_3,
                R.drawable.img_home_1, R.drawable.img_home_2, R.drawable.img_home_3),
            imageWidth=100,
            imageHeight=150
        ),

        Contents (
            title= "왓챠파티",
            images= listOf(R.drawable.img_home_party_1, R.drawable.img_home_party_2,
                R.drawable.img_home_party_1, R.drawable.img_home_party_2),
            imageWidth =196,
            imageHeight= 185

        )
    )

    val banners = listOf(

        R.drawable.img_home_newcontent_1,
        R.drawable.img_home_newcontent_2,
        R.drawable.img_home_newcontent_3
    )

}