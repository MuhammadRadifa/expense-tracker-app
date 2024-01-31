package com.example.expensetrackerapp.ui.screen.summary

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.expensetrackerapp.ui.util.TabSummaryList

@Composable
fun SummaryScreen(innerPadding:PaddingValues = PaddingValues(20.dp)){
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
        Tabs()
        Spacer(Modifier.height(16.dp))
        SummaryList()
    }
}

@Composable
fun Tabs(){
    Row(
        modifier = Modifier.fillMaxWidth(),
    ) {
        TabSummaryList.forEach{
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
            Spacer(Modifier.width(10.dp))
        }

    }

}

@Composable
fun SummaryList(){
    Column(
        Modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(5)
            )
    ) {
        Column {
            CardSummaryItem()
            CardSummaryItem()
            CardSummaryItem()
            CardSummaryItem()
            CardSummaryItem()
        }
    }
}

@Composable
fun CardSummaryItem(){
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
                Column(
                    modifier = Modifier.width(160.dp)
                ) {
                    Text(
                        text = "Foods",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Spacer(Modifier.height(8.dp))
                    LinearProgressIndicator(progress = 0.4f)
                }
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = "Rp. 10.000",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "10%",
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SummaryScreenPreview(){
    SummaryScreen()
}