package com.example.med_check_app

import ReminderContentButtons
import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun ReminderContent() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier.padding(16.dp),
            backgroundColor = Color(0xFF999999),
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Medicin",
                    style = MaterialTheme.typography.body1,
                    fontSize = 20.sp,
                    modifier = Modifier.weight(1f).padding(horizontal = 45.dp)
                )
                Text(
                    text = "Tid",
                    style = MaterialTheme.typography.body1,
                    fontSize = 23.sp,
                    modifier = Modifier.weight(1f).padding(horizontal = 60.dp)
                )

            }
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




