package com.example.med_check_app

import ReminderContentButtons
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReminderContent() {
    Column (
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()){
        Card(
            modifier = Modifier.padding(16.dp),
            backgroundColor = Color(0xFF999999),
            elevation = 4.dp
        ) {
            Text(
                text = "             Tid",
                modifier = Modifier
                    .padding(16.dp)
                    .width(320.dp),
                style = MaterialTheme.typography.body1,
                fontSize = 23.sp
            )
            Text(
                text = "                                 Medicin",
                modifier = Modifier
                    .padding(16.dp)
                    .width(320.dp),
                style = MaterialTheme.typography.body1,
                fontSize = 23.sp
            )
        }
        ReminderContentButtons()
    }
}

@Composable
fun ReminderTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Påmindelser",
                style = MaterialTheme.typography.h6
            )
        }
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ReminderPage() {
    Scaffold(
        topBar = { ReminderTopBar() },
        content = { ReminderContent() }
    )
}

