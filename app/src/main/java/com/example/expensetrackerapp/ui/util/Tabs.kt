package com.example.expensetrackerapp.ui.util

data class TabsItem(
    val title:String
)

val TabsList = listOf<TabsItem>(
    TabsItem("today"),
    TabsItem("This Month"),
    TabsItem("This Year")
)

val TabsMap = mapOf<Int,String>(
    0 to  "Today",
    1 to "This Month",
    2 to "This Year"
)

val TabSummaryList = listOf<TabsItem>(
    TabsItem("Month"),
    TabsItem("Year")
)