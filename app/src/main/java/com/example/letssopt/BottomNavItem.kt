package com.example.letssopt

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Main : BottomNavItem("main", "메인", Icons.Default.Home)
    object Category : BottomNavItem("category", "채널구매", Icons.Default.List)
    object Clip : BottomNavItem("clip", "클립", Icons.Default.PlayArrow)
    object Search : BottomNavItem("search", "찾기", Icons.Default.Search)
    object My : BottomNavItem("my", "보관함", Icons.Default.Person)
}