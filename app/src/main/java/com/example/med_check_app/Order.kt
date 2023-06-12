package com.example.med_check_app

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

@Composable
fun OrderContent() {
    var showOrderButton by remember { mutableStateOf(false) }
    var showConfirmationButton by remember { mutableStateOf(false) }
    var showOrderConfirmed by remember { mutableStateOf(false) }

    val medications = remember {
        mutableStateListOf("Paracetamol", "Morfin", "Propanolol", "Terbutalin","Paracetamol", "Morfin", "Propanolol", "Terbutalin","Paracetamol", "Morfin", "Propanolol", "Terbutalin")
    }
    val selectedMedications = remember { mutableStateListOf<String>() }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(bottom = 100.dp)
        ) {
            items(medications) { medication ->
                var isSelected by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            isSelected = !isSelected
                            if (isSelected) {
                                selectedMedications.add(medication)
                            } else {
                                selectedMedications.remove(medication)
                            }
                            showOrderButton = selectedMedications.isNotEmpty()
                            showConfirmationButton = false
                        }
                        .padding(8.dp)
                        .border(
                            width = 1.dp,
                            color = Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = isSelected,
                            onCheckedChange = { isSelected = it },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(text = medication)
                    }
                }
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (showOrderConfirmed) {
                Icon(
                    imageVector = Icons.Filled.CheckCircle,
                    contentDescription = "Bestilling bekræftet",
                    tint = Color.Green,
                    modifier = Modifier.size(100.dp)
                )
                Text("Bestilling bekræftet", fontSize = 30.sp)
                LaunchedEffect(Unit) {
                    delay(1200)
                    showOrderConfirmed = false
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .align(Alignment.BottomCenter)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Cyan,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .width(250.dp)
                    .padding(end = 16.dp),
                onClick = {
                    // Handle leveringsstatus button click
                }
            ) {
                Text("Leveringsstatus", fontSize = 25.sp)
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = if (showOrderButton) Color.Green else Color.Gray,
                    contentColor = Color.Black
                ),
                modifier = Modifier.width(200.dp),
                onClick = {
                    if (selectedMedications.isNotEmpty()) {
                        showConfirmationButton = true
                        showOrderButton = false
                    }
                }
            ) {
                Text("Bestil", fontSize = 25.sp)
            }
        }

        if (showConfirmationButton) {
            AlertDialog(
                onDismissRequest = {
                    showConfirmationButton = false
                    showOrderButton = true
                },
                title = {
                    Text(text = "Valgte Mediciner")
                },
                text = {
                    Column(
                        modifier = Modifier.verticalScroll(rememberScrollState())
                    ) {
                        selectedMedications.forEach { medication ->
                            val arrivalText = "$medication ankomst: d.6/7"
                            TextField(
                                value = arrivalText,
                                onValueChange = { },
                                label = { Text("$medication Ankomst") },
                                readOnly = true,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showConfirmationButton = false
                            showOrderConfirmed = true
                        }
                    ) {
                        Text("Bekræft")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = {
                            showConfirmationButton = false
                            showOrderButton = true
                        }
                    ) {
                        Text("Annuller")
                    }
                }
            )
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

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OrderPage() {
    Scaffold(
        topBar = { OrderTopBar() },
        content = { OrderContent() }
    )
}
