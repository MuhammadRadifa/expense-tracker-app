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
    var tabIndexState by mutableIntStateOf(0)

    lateinit var getAllExpense: Flow<List<Expense>>
    lateinit var getAllExpenseYear: Flow<List<Expense>>
    lateinit var getAllExpenseMonth: Flow<List<Expense>>
    lateinit var getAllExpenseDay:Flow<List<Expense>>

    init {
        viewModelScope.launch {
            getAllExpense = _expenseRepository.getAllExpense()
            getAllExpenseYear= _expenseRepository.getAllExpenseFilter("%Y")
            getAllExpenseMonth= _expenseRepository.getAllExpenseFilter("%Y-%m")
            getAllExpenseDay = _expenseRepository.getAllExpenseFilter("%Y-%m-%d")
        }
    }

    fun onStateChange(amount: Int? = null, desc: String? = null, category: String? = null, date: Long? = null) {
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
            date = System.currentTimeMillis()
        )
    }


    fun changeTabIndex(index:Int){
        tabIndexState = index
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