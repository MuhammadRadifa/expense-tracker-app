package com.example.expensetrackerapp.ui.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title:String,
    val unSelectedIcon:ImageVector,
    val selectedIcon: ImageVector
)

val itemsNavigation = listOf<NavigationItem>(
    NavigationItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home
    ),
    NavigationItem(
        title = "Summary",
        selectedIcon = Icons.Filled.Menu,
        unSelectedIcon = Icons.Outlined.Menu
    ),
)