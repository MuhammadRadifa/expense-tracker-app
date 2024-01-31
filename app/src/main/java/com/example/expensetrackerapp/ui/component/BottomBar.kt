package com.example.expensetrackerapp.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetrackerapp.R
import com.example.expensetrackerapp.ui.util.itemsNavigation

@Composable
fun BottomBar(){
    NavigationBar(
        containerColor = Color.White
    ) {
        itemsNavigation.forEach{
            items ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.White,
                    unselectedIconColor = Color(0xFFACB1D6),
                    unselectedTextColor = Color(0xFFACB1D6)
                ),
                selected = true,
                label = { Text(text = items.title)},
                onClick = { /*TODO*/ },
                icon = {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = items.selectedIcon,
                        contentDescription = items.title
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview(){
    BottomBar()
}