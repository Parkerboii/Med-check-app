package com.example.med_check_app

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

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
    }
}