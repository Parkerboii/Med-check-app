package com.example.med_check_app

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

@Composable
fun OrderContent() {

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .width(280.dp)
                .padding(20.dp),
            onClick = {
            }) {
            Text("Leveringsstatus", fontSize = 25.sp)
    }
    }
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .width(150.dp)
                .padding(20.dp),
            onClick = {
            }) {
            Text("Bestil", fontSize = 25.sp)
        }
    }
}

@Composable
fun OrderTopBar() {
    TopAppBar(title = {
        Text(
            text = "Bestil Medicin",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,

            )
    })
}
@Composable
fun OrderPage() {
    Scaffold(
        topBar = { OrderTopBar() },
        content = { OrderContent() }
    )
}