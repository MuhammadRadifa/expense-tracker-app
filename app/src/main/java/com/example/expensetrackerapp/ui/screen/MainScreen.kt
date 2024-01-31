package com.example.expensetrackerapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.expensetrackerapp.R
import com.example.expensetrackerapp.ui.component.BottomBar
import com.example.expensetrackerapp.ui.component.FloatingButton
import com.example.expensetrackerapp.ui.component.TopBar
import com.example.expensetrackerapp.ui.screen.home.HomeScreen
import com.example.expensetrackerapp.ui.screen.summary.SummaryScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(id = R.color.secondary),
        topBar = { TopBar()},
        floatingActionButton = { FloatingButton() },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomBar()
        }
    ) {
        innerPadding ->
        //HomeScreen(innerPadding = innerPadding)
        //SummaryScreen(innerPadding = innerPadding)
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreenPreview(){
    MainScreen()
}