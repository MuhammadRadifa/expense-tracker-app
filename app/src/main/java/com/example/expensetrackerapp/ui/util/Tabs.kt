package com.example.expensetrackerapp.ui.util

data class TabsItem(
    val title:String
)

val TabsList = listOf<TabsItem>(
    TabsItem("today"),
    TabsItem("This Week"),
    TabsItem("This Month")
)