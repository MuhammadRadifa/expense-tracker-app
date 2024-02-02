package com.example.expensetrackerapp.ui


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.expensetrackerapp.ui.screen.MainScreen
import com.example.expensetrackerapp.ui.screen.support.OnBoardingScreen

@Composable
fun MainApp() {
    val rootNavController = rememberNavController()

    NavHost(navController = rootNavController, startDestination = "onBoardingScreen" ){
        composable(route="mainScreen"){ MainScreen() }
        composable(route="onBoardingScreen"){ OnBoardingScreen(rootNavController) }
    }
}
