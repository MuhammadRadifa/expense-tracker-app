package com.example.expensetrackerapp.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.expensetrackerapp.R
import com.example.expensetrackerapp.ui.component.BottomBar
import com.example.expensetrackerapp.ui.component.FloatingButton
import com.example.expensetrackerapp.ui.component.TopBar
import com.example.expensetrackerapp.ui.screen.expense.AddExpenseScreen
import com.example.expensetrackerapp.ui.screen.home.HomeScreen
import com.example.expensetrackerapp.ui.screen.summary.SummaryScreen
import com.example.expensetrackerapp.ui.util.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel){

    val mainNavController = rememberNavController()
    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    )

    var showBottomSheet = remember { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = colorResource(id = R.color.secondary),
        topBar = { TopBar()},
        floatingActionButton = { FloatingButton(showBottomSheet) },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomBar(mainNavController,navBackStackEntry)
        }
    ) {
        innerPadding ->
        NavHost(navController = mainNavController, startDestination = "home" ){
            composable(route="home"){ HomeScreen(innerPadding = innerPadding, viewModel = viewModel) }
            composable(route="summary"){ SummaryScreen(innerPadding = innerPadding, viewModel = viewModel) }
        }
        if (showBottomSheet.value) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet.value = false
                },
                containerColor = Color.White,
                sheetState = sheetState,
            ) {
                AddExpenseScreen(showBottomSheet,viewModel)
            }
        }
    }

}
