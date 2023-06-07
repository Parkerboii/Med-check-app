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
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ReminderPage() {
    Scaffold(
        topBar = { ReminderTopBar() },
        content = { ReminderContent() }
    )
}
@Composable
fun ReminderTopBar() {
    TopAppBar(title = {
        Text(
            text = "Påmindelser",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            )
    })
}

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
                text = "Tid",
                text = "Medicin",
                modifier = Modifier.padding(16.dp).width(300.dp),
                style = MaterialTheme.typography.body1,
                fontSize = 23.sp
            )
        }
    }
}
