package com.example.expensetrackerapp.data

import android.content.Context
import androidx.room.Room

object Graph {
    lateinit var database: ExpenseDatabase

    val expenseRepository by lazy {
        ExpenseRepository(expenseDao = database.expenseDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(
            context = context,
            klass = ExpenseDatabase::class.java,
            name = "expensetracker.db"
        ).build()
    }

}