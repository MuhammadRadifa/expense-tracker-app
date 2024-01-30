package com.example.expensetrackerapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.expensetrackerapp.ui.component.BottomBar
import com.example.expensetrackerapp.ui.component.FloatingButton

@Composable
fun MainScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = { FloatingButton() },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomBar()
        }
    ) {
        paddingValues ->
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview(){
    MainScreen()
}