package com.example.expensetrackerapp.ui.util

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetrackerapp.data.Expense
import com.example.expensetrackerapp.data.ExpenseRepository
import com.example.expensetrackerapp.data.Graph
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel(
    private val _expenseRepository:ExpenseRepository = Graph.expenseRepository
):ViewModel() {

    var expenseState by mutableStateOf(Expense())

    lateinit var getAllExpense: Flow<List<Expense>>

    init {
        viewModelScope.launch {
            getAllExpense = _expenseRepository.getAllExpense()
        }
    }

    fun onStateChange(amount: Int? = null, desc: String? = null, category: String? = null, date: String? = null) {
        expenseState = expenseState.copy(
            amount = amount ?: expenseState.amount,
            description = desc ?: expenseState.description,
            category = category ?: expenseState.category,
            date = date ?: expenseState.date
        )
    }

    fun resetState(){
        expenseState = expenseState.copy(
            id = 0L,
            category = "Foods",
            amount = 0,
            description = "",
            date = ""
        )
    }

    fun addExpense(expense: Expense){
        viewModelScope.launch(Dispatchers.IO) {
            _expenseRepository.addExpense(expense)
        }
    }

    fun updateExpense(expense: Expense){
        viewModelScope.launch(Dispatchers.IO) {
            _expenseRepository.updateExpense(expense)
        }
    }

    fun deleteExpense(expense: Expense){
        viewModelScope.launch(Dispatchers.IO){
            _expenseRepository.deleteExpense(expense)
        }
    }

}