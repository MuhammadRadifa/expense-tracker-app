package com.example.expensetrackerapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import com.example.expensetrackerapp.ui.util.MainViewModel
import com.example.expensetrackerapp.ui.util.TabsList

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
                CardItem()
            }
        }
    }
}

@Composable
fun CardItem(){
    Spacer(Modifier.height(16.dp))
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "logo",
                )
                Column {
                    Text(
                        text = "Burger King",
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
                text = "Rp. 10.000",
                fontWeight = FontWeight.Medium
            )
        }
    }
}
