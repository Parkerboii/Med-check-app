/*package com.example.med_check_app

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.*
import androidx.compose.material.Icon as Icon1
 */
/*
@Composable
fun ReminderContent() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text(text = "ReminderPage", fontSize = 50.sp)
    }
}
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
 */
/*
@Composable
fun VerticalBar() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Item 1")
        Text("Item 2")
        Button(onClick = { /* Handle button click */ }) {
            Text("Button")
        }
        // Add more content here
    }
}



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ReminderPage() {
    Scaffold(
        topBar = { ReminderTopBar() },
        content = { ReminderContent() }
    )
}

@Composable
fun ReminderContent() {
    TODO("Not yet implemented")
}

@Composable
fun ReminderTopBar() {
    TopAppBar(title = {
        Text(
            text = "Påmindelser",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
    })
}
*/
package com.example.med_check_app

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    }
    val tasks = remember { mutableStateListOf("Paracetamol", "Morfin", "Paracetamol") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Dine påmindelser",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        tasks.forEachIndexed { index, task ->
            var isChecked by remember { mutableStateOf(false) }
            var isTimerSet by remember { mutableStateOf(false) }
            var countdownJob: Job? by remember { mutableStateOf(null) }
            var countdownSeconds by remember { mutableStateOf(10) }

            Column(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(8.dp)
                    .clickable {
                        isTimerSet = true
                    }
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = task)
                }
            }

            if (isTimerSet && countdownJob == null) {
                countdownJob = coroutineScope.launch {
                    for (seconds in countdownSeconds downTo 1) {
                        countdownSeconds = seconds
                        delay(1000L) // 1 second delay
                    }
                    isTimerSet = false
                    countdownJob = null
                }
            }
        }
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

@Composable
fun ReminderPage() {
    Scaffold(
        topBar = { ReminderTopBar() },
        content = { ReminderContent() }
    )
}

