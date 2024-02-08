package com.example.expensetrackerapp.ui.util

data class TabsItem(
    val title:String
)

val TabsList = listOf<TabsItem>(
    TabsItem("today"),
    TabsItem("This Week"),
    TabsItem("This Month")
)

val TabsMap = mapOf<Int,String>(
    0 to  "Today",
    1 to "This Week",
    2 to "This Month"
)

val TabSummaryList = listOf<TabsItem>(
    TabsItem("Month"),
    TabsItem("Year")
)