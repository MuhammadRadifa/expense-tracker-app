package com.example.expensetrackerapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id:Long = 0L,
    @ColumnInfo(name = "amount")
    val amount:Int = 0,
    @ColumnInfo(name = "description")
    val description:String = "",
    @ColumnInfo(name = "category")
    val category:String = "",
    @ColumnInfo(name = "date")
    val date:String = ""
)