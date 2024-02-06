package com.example.expensetrackerapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Expense::class],
    version = 1,
    exportSchema = false
)

abstract class ExpenseDatabase:RoomDatabase(){
    abstract fun expenseDao():ExpenseDao
}