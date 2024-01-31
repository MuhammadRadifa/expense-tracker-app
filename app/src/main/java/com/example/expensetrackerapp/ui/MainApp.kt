package com.example.expensetrackerapp.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.expensetrackerapp.ui.screen.MainScreen
import com.example.expensetrackerapp.ui.screen.expense.AddExpenseScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    //AddExpenseScreen()
    MainScreen()
}
