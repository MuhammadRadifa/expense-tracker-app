package com.example.expensetrackerapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
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
import com.example.expensetrackerapp.ui.screen.expense.DetailExpenseScreen
import com.example.expensetrackerapp.ui.util.MainViewModel
import com.example.expensetrackerapp.ui.util.TabsList
import com.example.expensetrackerapp.ui.util.categoriesImage

@Composable
fun HomeScreen(
    innerPadding:PaddingValues = PaddingValues(20.dp),
    viewModel: MainViewModel
){
    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(10.dp)) {
        Tabs()
        Spacer(Modifier.height(16.dp))
        SummaryBox()
        Spacer(Modifier.height(16.dp))
        ListSummary(viewModel = viewModel)

    }
}

@Composable
fun Tabs(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TabsList.forEach{
            items ->
            OutlinedButton(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.secondary),
                    contentColor = colorResource(id = R.color.background)
                )
            ) {
                Text(items.title)
            }
        }

    }

}

@Composable
fun SummaryBox(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(
                color = colorResource(id = R.color.background),
                shape = RoundedCornerShape(10)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Spend So Far",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Rp. 200.000",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListSummary(viewModel: MainViewModel){
    Column{
        Text(
            text = "Today, 3 Oct",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        val expenseList = viewModel.getAllExpense.collectAsState(initial = listOf())
        LazyColumn{
            items(expenseList.value, key = {key -> key.id}){
                expense ->
                CardItem(expense)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(expense: Expense){
    val showBottomSheetDetail = remember{ mutableStateOf(false) }
    Spacer(Modifier.height(16.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .clickable { showBottomSheetDetail.value = true },
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
                    painter = painterResource(id = categoriesImage[expense.category]!!),
                    contentDescription = "logo",
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = expense.description,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "10:00 Wita",
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
            Text(
                text = expense.amount.toString(),
                fontWeight = FontWeight.Medium
            )
        }
        if(showBottomSheetDetail.value){
            ModalBottomSheet(onDismissRequest = { showBottomSheetDetail.value = false }, containerColor = Color.White) {
                DetailExpenseScreen(showBottomSheet = showBottomSheetDetail, expense = expense)
            }
        }
    }
}
