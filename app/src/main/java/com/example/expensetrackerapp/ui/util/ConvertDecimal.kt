package com.example.expensetrackerapp.ui.util

import android.icu.text.DecimalFormat
import android.icu.text.NumberFormat
import java.util.Locale

fun ConvertDecimal(amount:Int):String{
    val decimalFormat = NumberFormat.getNumberInstance(Locale("id", "ID")) as DecimalFormat
    decimalFormat.applyPattern("###,###.###")
    return decimalFormat.format(amount)
}