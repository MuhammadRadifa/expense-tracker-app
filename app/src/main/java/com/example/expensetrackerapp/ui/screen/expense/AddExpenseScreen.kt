package com.example.expensetrackerapp.ui.screen.expense

import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.expensetrackerapp.R
import com.example.expensetrackerapp.data.Expense
import com.example.expensetrackerapp.ui.util.DateConverter
import com.example.expensetrackerapp.ui.util.MainViewModel
import com.example.expensetrackerapp.ui.util.categoriesImage
import com.example.expensetrackerapp.ui.util.categoriesTitle
import kotlinx.coroutines.launch

@Composable
fun AddExpenseScreen(
    showBottomSheet: MutableState<Boolean>,
    viewModel: MainViewModel,
    expense: Expense = Expense()
) {
    val isUpdate = expense.id != 0L
    LaunchedEffect(isUpdate) {
        if (isUpdate) {
            viewModel.onStateChange(
                date = expense.date,
                amount = expense.amount,
                category = expense.category,
                desc = expense.description
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(20.dp)
    ) {
        IconButton(
            onClick = {
                showBottomSheet.value = false
                viewModel.resetState()
            },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = colorResource(id = R.color.secondary)
            )
        ) {
            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
        }
        Spacer(Modifier.height(16.dp))
        Text(
            text = if (isUpdate) "Modify Expense" else "Add New Expense",
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
        InputForm(showBottomSheet, viewModel, isUpdate, expense.id)
    }
}

@Composable
fun InputForm(
    showBottomSheet: MutableState<Boolean>,
    viewModel: MainViewModel,
    isUpdate: Boolean,
    id: Long
) {
    val scope = rememberCoroutineScope()
    var showDialogCategories = remember { mutableStateOf(false) }
    var showDialogDate = remember { mutableStateOf(false) }

    Column {
        Text(text = "Enter Amount", fontSize = 18.sp, fontWeight = FontWeight.Bold)
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
            onValueChange = {
                viewModel.onStateChange(amount = if(it.isBlank())0 else it.toInt())
            },
            leadingIcon = {
                Text(text = "Rp")
            },
            placeholder = { Text(text = "10.000", color = Color.Gray) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        Spacer(Modifier.height(16.dp))
        Text(text = "Description", fontSize = 18.sp, fontWeight = FontWeight.Bold)
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
            onValueChange = { viewModel.onStateChange(desc = it) },
            placeholder = { Text(text = "Burger King And Coca Cola", color = Color.Gray) },
            singleLine = true
        )
        Spacer(Modifier.height(16.dp))
        Text(text = "Category", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { showDialogCategories.value = true },
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
                    Icon(
                        painter = painterResource(id = categoriesImage[viewModel.expenseState.category]!!),
                        contentDescription = "category"
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = viewModel.expenseState.category,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Button",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        Text(text = "Date", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { showDialogDate.value = true },
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
                Text(
                    text = DateConverter(viewModel.expenseState.date),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )
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
                if (isUpdate) {
                    viewModel.updateExpense(
                        Expense(
                            id = id,
                            amount = viewModel.expenseState.amount,
                            description = viewModel.expenseState.description,
                            category = viewModel.expenseState.category,
                            date = viewModel.expenseState.date
                        )
                    )
                } else {
                    viewModel.addExpense(
                        viewModel.expenseState
                    )
                }

                viewModel.resetState()

                scope.launch {
                    showBottomSheet.value = false
                }
            }
        ) {
            Text(
                text = if (isUpdate) "Update Expense" else "Add Expense",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }

    if (showDialogCategories.value) {
        CategoryDialog(viewModel = viewModel, showDialog = showDialogCategories)
    }

    if (showDialogDate.value) {
        DateDialog(showDialog = showDialogDate, viewModel = viewModel)
    }
}

@Composable
fun CategoryDialog(viewModel: MainViewModel, showDialog: MutableState<Boolean>) {
    Dialog(
        onDismissRequest = { showDialog.value = false },
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .clip(shape = RoundedCornerShape(10)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                Modifier
                    .padding(10.dp)
                    .background(Color.White)
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Select Your Category",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                LazyVerticalGrid(columns = GridCells.Fixed(2), Modifier.padding(bottom = 16.dp)) {
                    items(categoriesTitle) { title ->
                        val isSelected = title == viewModel.expenseState.category
                        Button(
                            onClick = {
                                viewModel.onStateChange(category = title)
                                showDialog.value = false
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .padding(4.dp)
                                .defaultMinSize(minWidth = 1.dp, minHeight = 10.dp),
                            shape = RoundedCornerShape(20),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = if (isSelected) R.color.background else R.color.secondary),
                                contentColor = colorResource(id = if (isSelected) R.color.secondary else R.color.background),
                            )
                        ) {
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = categoriesImage[title]!!),
                                    contentDescription = "Button",
                                    modifier = Modifier.size(28.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                                Text(
                                    text = title,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = if (isSelected) Color.White else Color.Gray
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateDialog(showDialog: MutableState<Boolean>, viewModel: MainViewModel) {
    val state = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = { showDialog.value = false },
        confirmButton = {
            TextButton(
                onClick = {
                    showDialog.value = false
                }
            ) {
                viewModel.onStateChange(date = state.selectedDateMillis)
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    showDialog.value = false
                }
            ) {
                Text("CANCEL")
            }
        },
        colors = DatePickerDefaults.colors(
            containerColor = Color.White
        )
    ) {
        DatePicker(
            state = state,
        )
    }


}

//@Preview(showBackground = true)
//@Composable
//fun CategoryDialogPreview(){
//    CategoryDialog()
//}
