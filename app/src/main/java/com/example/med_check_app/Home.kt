package com.example.med_check_app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomePage(navController: NavController) {
    Scaffold(
        topBar = { HomeTopBar() },
        content = { HomeScreen(navController) }
    )
}
@Composable
fun HomeTopBar() {
    TopAppBar(title = {
        Text(
            text = "Home",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,

            )
    })
}

@Composable
fun HomeScreen(navController: NavController){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black),
            modifier = Modifier
                .width(300.dp)
                .padding(20.dp),
            onClick = {
                navController.navigate(Screen.MedicinPage.route)
            }) {
            Text("Medicin", fontSize = 30.sp)

        }
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black),
            modifier = Modifier
                .width(300.dp)
                .padding(20.dp),
            onClick = { navController.navigate((Screen.ReminderPage.route)) }) {
            Text("Påmindelser", fontSize = 30.sp)
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black),
            modifier = Modifier
                .width(300.dp)
                .padding(20.dp),
            onClick = { navController.navigate((Screen.OrderPage.route)) }) {
            Text("Bestil Medicin", fontSize = 30.sp)
        }
        Button(onClick = { navController.navigate((Screen.DataScreen.route)) }) {
            Text("Bestil Medicin", fontSize = 30.sp)
        }
    }
}
