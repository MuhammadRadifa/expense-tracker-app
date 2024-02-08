package com.example.expensetrackerapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "expense")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    @ColumnInfo(name = "amount")
    var amount:Int = 0,
    @ColumnInfo(name = "description")
    var description:String = "",
    @ColumnInfo(name = "category")
    var category:String = "Foods",
    @ColumnInfo(name = "date")
    var date:Long = System.currentTimeMillis()
)