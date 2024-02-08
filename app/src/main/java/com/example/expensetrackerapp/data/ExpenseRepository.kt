package com.example.expensetrackerapp.data

import kotlinx.coroutines.flow.Flow

class ExpenseRepository(private val expenseDao:ExpenseDao){
    suspend fun addExpense(expense: Expense){
        expenseDao.addExpense(expense)
    }

    fun getAllExpense(): Flow<List<Expense>> = expenseDao.getAllExpense()

    fun getAllExpenseFilter(filter:String): Flow<List<Expense>> = expenseDao.getAllExpenseFilter(filter)

    //fun getExpenseById(id:Long):Flow<Expense> = expenseDao.getExpenseById(id)

    suspend fun updateExpense(expense: Expense){
        expenseDao.updateExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense){
        expenseDao.deleteExpense(expense)
    }

}