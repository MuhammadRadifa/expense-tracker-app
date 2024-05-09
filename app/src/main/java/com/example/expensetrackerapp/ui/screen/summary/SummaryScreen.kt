package com.example.expensetrackerapp.ui.screen.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetrackerapp.R
import com.example.expensetrackerapp.data.Expense
import com.example.expensetrackerapp.ui.util.ConvertDecimal
import com.example.expensetrackerapp.ui.util.MainViewModel
import com.example.expensetrackerapp.ui.util.TabSummaryList
import com.example.expensetrackerapp.ui.util.categoriesImage

@Composable
fun SummaryScreen(innerPadding:PaddingValues = PaddingValues(20.dp),viewModel: MainViewModel){
    var tabIndex = remember{ mutableIntStateOf(0) }
    val expenseList = when (tabIndex.value) {
        0-> viewModel.getAllExpenseMonth.collectAsState(initial = listOf())
        else -> viewModel.getAllExpenseYear.collectAsState(initial = listOf())
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(10.dp)) {
        Text(
            text = "Your Summary",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        Tabs(tabIndex)
        Spacer(Modifier.height(16.dp))
        if (expenseList.value.isEmpty()){
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.height(48.dp))
                Image(
                    painter = painterResource(id = R.drawable.undraw_no_data_re_kwbl),
                    contentDescription = "No Expense Yet",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "No Expense Yet",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }else{
            SummaryList(expenseList)
        }

    }
}

@Composable
fun Tabs(tabIndex:MutableIntState){
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        TabSummaryList.forEachIndexed(){
                index,items ->
            val isSelected = tabIndex.value == index
            OutlinedButton(
                onClick = { tabIndex.value = index  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = if(isSelected)R.color.background else R.color.secondary),
                    contentColor = colorResource(id = if(isSelected)R.color.secondary else R.color.background)
                )
            ) {
                Text(items.title)
            }
            Spacer(Modifier.width(10.dp))
        }

    }

}

@Composable
fun SummaryList(expenseList: State<List<Expense>>){
    val uniqueCategories = expenseList.value.map { it.category }.distinct()
    val totalAmount = expenseList.value.sumOf { it.amount }
    Column(
        Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(5)
            )
    ) {
        LazyColumn {
            items(uniqueCategories){
                categories ->
                CardSummaryItem(categories,expenseList,totalAmount)
            }
        }
    }
}

@Composable
fun CardSummaryItem(categories:String,expenseList: State<List<Expense>>,totalAmount:Int){
    val amountCategory =  expenseList.value.filter { it.category == categories }.sumOf { it.amount }
    val percentage = if (totalAmount != 0) {
        (amountCategory.toDouble() / totalAmount) * 100
    } else {
        0.0
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxHeight()) {
                Icon(
                    painter = painterResource(id = categoriesImage[categories]!!),
                    modifier = Modifier.size(32.dp),
                    contentDescription = categories,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier.width(160.dp)
                ) {
                    Text(
                        text = categories,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = (percentage/100).toFloat(),
                        color = colorResource(id = R.color.background)
                    )
                }
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Rp. ${ConvertDecimal(amountCategory)}",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${percentage.toInt()}%",
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}
