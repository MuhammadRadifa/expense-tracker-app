package com.example.expensetrackerapp.ui.screen.expense

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

@Composable
fun AddExpenseScreen(showBottomSheet:MutableState<Boolean>,viewModel: MainViewModel){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp)
    ) {
        IconButton(
            onClick = { showBottomSheet.value = false },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = colorResource(id = R.color.secondary)
            )
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Add New Expense",
            fontSize = 28.sp,
            fontWeight = FontWeight(600)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Enter the detail of your expense to help you to track your spending",
            fontSize = 18.sp,
            color = Color.Gray,
        )
        Spacer(Modifier.height(16.dp))
        InputForm(showBottomSheet,viewModel)
    }
}

@Composable
fun InputForm(showBottomSheet:MutableState<Boolean>,viewModel: MainViewModel){
    val scope = rememberCoroutineScope()
    Column {
        Text(text = "Enter Amount", fontSize = 18.sp ,fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(20),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(id = R.color.tertiary),
                focusedContainerColor = colorResource(id = R.color.secondary),
                unfocusedContainerColor = colorResource(id = R.color.secondary),
                unfocusedIndicatorColor = colorResource(id = R.color.secondary),
            ),
            value = viewModel.expenseState.amount.toString(),
            onValueChange = {viewModel.onStateChange(amount = it.toInt())},
            leadingIcon = {
                Text(text = "Rp")
            },
            placeholder = { Text(text = "10.000", color = Color.Gray) },
            singleLine = true
        )
        Spacer(Modifier.height(16.dp))
        Text(text = "Description", fontSize = 18.sp ,fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(20),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = colorResource(id = R.color.tertiary),
                focusedContainerColor = colorResource(id = R.color.secondary),
                unfocusedContainerColor = colorResource(id = R.color.secondary),
                unfocusedIndicatorColor = colorResource(id = R.color.secondary)
            ),
            value = viewModel.expenseState.description,
            onValueChange = {viewModel.onStateChange(desc = it)},
            placeholder = { Text(text = "Burger King And Coca Cola", color = Color.Gray) },
            singleLine = true
        )
        Spacer(Modifier.height(16.dp))
        Text(text = "Description", fontSize = 18.sp ,fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .defaultMinSize(minWidth = 1.dp, minHeight = 10.dp),
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
                contentColor = Color.Black
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "category")
                    Text(text = "Foods", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Button",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(text = "Date", fontSize = 18.sp ,fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { /*TODO*/ },
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .defaultMinSize(minWidth = 1.dp, minHeight = 10.dp),
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.secondary),
                contentColor = colorResource(id = R.color.background)
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "08/20/2024", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color.Gray)
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Button",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        Spacer(Modifier.height(24.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(20),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.background)
            ),
            onClick = {
                viewModel.addExpense(
                    viewModel.expenseState
                )

                scope.launch {
                    showBottomSheet.value = false
                }
            }
        ) {
            Text(text = "Add Expense", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        }
    }

}
