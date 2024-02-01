package com.example.expensetrackerapp.ui.screen.expense

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetrackerapp.R

@Composable
fun DetailExpenseScreen(){
    Column(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Expense Transaction Details",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        Spacer(Modifier.height(16.dp))
        Column(Modifier.fillMaxWidth()) {
            Text(
                text = "Burger and Coca cola",
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            Text(
                text = "Rp. 10.000",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Divider(Modifier.padding(vertical = 16.dp))
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Category",
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            Text(
                text = "Foods",
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "Date",
                fontWeight = FontWeight.Medium,
                color = Color.Gray
            )
            Text(
                text = "Sat, 3 june 2024",
                fontWeight = FontWeight.Bold,
            )
        }
        Spacer(Modifier.height(30.dp))
        Row(Modifier.fillMaxWidth()) {
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEDEFF3),
                    contentColor = colorResource(id = R.color.background)
                ),
                modifier = Modifier.fillMaxWidth(0.5f)
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                Spacer(Modifier.width(10.dp))
                Text(text = "Modify", fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(8.dp))
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(20),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFDF0EF),
                    contentColor = Color(0xFFC70039)
                ),
                modifier = Modifier.fillMaxWidth(1f)
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Edit")
                Spacer(Modifier.width(10.dp))
                Text(text = "Delete", fontWeight = FontWeight.Bold)
            }
        }
    }
}