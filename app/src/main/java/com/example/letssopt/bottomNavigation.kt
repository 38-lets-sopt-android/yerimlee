package com.example.letssopt



sealed class BottomNavItem (

    val route: String,
    val label: String,
    val icon: Int

) {

    object Main : BottomNavItem (

        route = "main",
        label="메인",
        icon = R.drawable.main

    )

    object Purchase : BottomNavItem (


        route= "purchase",
        label= "개별구매",
        icon = R.drawable.category,
    )


    object Webtoon : BottomNavItem (

        route= "webtoon",
        label= "웹툰",
        icon= R.drawable.wallet,
    )

    object Find : BottomNavItem(

        route= "find",
        label ="찾기",
        icon = R.drawable.search,
    )

    object Folder : BottomNavItem (

        route= "folder",
        label= "보관함",
        icon = R.drawable.folder)


}