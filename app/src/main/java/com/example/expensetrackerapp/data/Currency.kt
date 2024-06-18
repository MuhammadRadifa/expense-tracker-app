package com.example.expensetrackerapp.data

import android.annotation.SuppressLint
import java.text.NumberFormat
import java.util.Locale

@SuppressLint("ConstantLocale")
val numberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
val currencySymbol = numberFormat.currency?.symbol ?: "$"
