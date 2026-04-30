package com.example.letssopt

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {

    val navItems = listOf(
        BottomNavItem.Main,
        BottomNavItem.Purchase,
        BottomNavItem.Webtoon,
        BottomNavItem.Find,
        BottomNavItem.Folder
    )

    var selectedRoute by remember { mutableStateOf("main") }

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .padding(horizontal = 18.dp, vertical = 11.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                navItems.forEach { item ->
                    Column(
                        modifier = Modifier.clickable { selectedRoute = item.route },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = item.icon),
                            contentDescription = item.label,
                            modifier = Modifier.size(24.dp),
                            colorFilter= ColorFilter.tint (
                                if (selectedRoute==item.route) Color.White
                                else Color.Gray
                            )
                        )

                        Text(
                            text= item.label,
                            color = if (selectedRoute ==item.route) Color.White
                            else Color.Gray,
                            fontSize=12.sp
                        )

                    }
                }
            }
        }
    ) { innerPadding ->
        when (selectedRoute) {
            "main"     -> HomeScreen(modifier = Modifier.padding(innerPadding))
            "purchase" -> Text("개별구매", modifier = Modifier.padding(innerPadding))
            "webtoon"  -> Text("웹툰",    modifier = Modifier.padding(innerPadding))
            "find"     -> Text("찾기",    modifier = Modifier.padding(innerPadding))
            "folder"   -> Text("보관함",  modifier = Modifier.padding(innerPadding))
        }
    }
}