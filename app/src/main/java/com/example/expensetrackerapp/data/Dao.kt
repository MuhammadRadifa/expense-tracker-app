package com.example.expensetrackerapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ExpenseDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract suspend fun addExpense(wishEntity:Expense)

    @Query("SELECT * FROM `expense`")
    abstract fun getAllExpense(): Flow<List<Expense>>

//    @Query("SELECT * FROM  `expense` WHERE strftime('%Y-%m-%d', datetime(date/ 1000, 'unixepoch')) = strftime('%Y-%m-%d', 'now')")
//    abstract fun getAllExpenseToday():Flow<List<Expense>>
//
//    @Query("SELECT * FROM  `expense` WHERE strftime('%Y-%m', datetime(date / 1000, 'unixepoch')) = strftime('%Y-%m', 'now')")
//    abstract fun getAllExpenseMonth():Flow<List<Expense>>
//
//    @Query("SELECT * FROM  `expense` WHERE ")
//    abstract fun getAllExpenseMonth():Flow<List<Expense>>

    @Query("SELECT * FROM  `expense` WHERE strftime(:filter, datetime(date/ 1000, 'unixepoch')) = strftime(:filter, 'now')")
    abstract fun getAllExpenseFilter(filter:String):Flow<List<Expense>>

    @Update
    abstract suspend fun updateExpense(wishEntity: Expense)

    @Delete
    abstract suspend fun deleteExpense(wishEntity: Expense)

    @Query("SELECT * FROM `expense` WHERE id=:id")
    abstract fun getExpenseById(id:Long):Flow<Expense>

}
