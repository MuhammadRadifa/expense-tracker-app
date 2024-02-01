package com.example.expensetrackerapp.ui.screen.support

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetrackerapp.R

@Composable
fun OnBoardingScreen(imagePainter:Int,heightImage: Int,title:String,description:String){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imagePainter),
            contentDescription = title,
            Modifier.height((heightImage).dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = description,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            modifier = Modifier.fillMaxWidth(0.75f)
        )
    }
}

@Composable
fun OnBoardingSecondScreen(){
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.stat),
            contentDescription = "First Icon",
            Modifier.height(200.dp)
        )
        Spacer(Modifier.height(16.dp))
        Text(
            text = "Record Expenses Quickly",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Expense Tracker makes daily expense tracking a breeze. Just a few taps to record your transactions",
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Light,
            modifier = Modifier.fillMaxWidth(0.75f)
        )
    }
}

@Composable
fun OnBoardingThirdScreen(){}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun OnBoardingPreview(){

//    OnBoardingScreen(
//        imagePainter = R.drawable.undraw_mobile_content_xvgr,
//        heightImage = 300,
//        title = "Welcome to Expense Tracker",
//        description = "Easily manage your finances. Expense Tracker helps you record and manage your daily expenses effortlessly")

//    OnBoardingScreen(
//        imagePainter = R.drawable.stat,
//        heightImage = 200,
//        title = "Record Expenses Quickly",
//        description = "Expense Tracker makes daily expense tracking a breeze. Just a few taps to record your transactions"
//    )

    OnBoardingScreen(
        imagePainter = R.drawable.real_time,
        heightImage = 260,
        title = "Real-time Financial Monitoring",
        description = "Monitor your finances instantly. Expense Tracker provides clear insights with informative graphs and reports for wise financial decisions"
    )
}