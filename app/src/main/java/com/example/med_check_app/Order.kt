package com.example.med_check_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/*@Composable
fun OrderContent() {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .width(500.dp)
                .padding(20.dp),
            onClick = {
            }) {
            Text("Paracetamol", fontSize = 30.sp)
        }
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Transparent,
                contentColor = Color.Black
            ),
            modifier = Modifier
                .width(500.dp)
                .padding(20.dp),
            onClick = {
            }) {
            Text("Morfin", fontSize = 30.sp)
        }
    }

    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan,
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
*/
@Composable
fun OrderContent() {
    var showParacetamolArrival by remember { mutableStateOf(false) }
    var paracetamolArrival by remember { mutableStateOf("") }

    var showMorfinArrival by remember { mutableStateOf(false) }
    var morfinArrival by remember { mutableStateOf("") }

    var showConfirmationButton by remember { mutableStateOf(false) }
    var showConfirmationText by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(bottom = 100.dp)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .width(500.dp)
                    .padding(20.dp),
                onClick = {
                    showParacetamolArrival = !showParacetamolArrival
                    if (showParacetamolArrival) {
                        paracetamolArrival = "Paracetamol ankomst: d.6/7"
                    } else {
                        paracetamolArrival = ""
                    }
                }
            ) {
                Text("Paracetamol", fontSize = 30.sp)
            }

            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Transparent,
                    contentColor = Color.Black
                ),
                modifier = Modifier
                    .width(500.dp)
                    .padding(20.dp),
                onClick = {
                    showMorfinArrival = !showMorfinArrival
                    if (showMorfinArrival) {
                        morfinArrival = "Morfin ankomst: d.6/7"
                    } else {
                        morfinArrival = ""
                    }
                }
            ) {
                Text("Morfin", fontSize = 30.sp)
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (showParacetamolArrival && paracetamolArrival.isNotEmpty()) {
                TextField(
                    value = paracetamolArrival,
                    onValueChange = { },
                    label = { Text("Paracetamol Ankomst") },
                    readOnly = true,
                    modifier = Modifier.padding(16.dp)
                )
            }

            if (showMorfinArrival && morfinArrival.isNotEmpty()) {
                TextField(
                    value = morfinArrival,
                    onValueChange = { },
                    label = { Text("Morfin Ankomst") },
                    readOnly = true,
                    modifier = Modifier.padding(16.dp)
                )
            }

            if (showConfirmationButton) {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Green,
                        contentColor = Color.Black
                    ),
                    modifier = Modifier
                        .width(300.dp)
                        .padding(top = 16.dp),
                    onClick = {
                        showConfirmationText = !showConfirmationText
                    }
                ) {
                    Text("Bekræft Bestilling", fontSize = 25.sp)
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
                    backgroundColor = Color.Gray,
                    contentColor = Color.Black
                ),
                modifier = Modifier.width(200.dp),
                onClick = {
                    showConfirmationButton = !showConfirmationButton
                    showConfirmationText = false
                }
            ) {
                Text("Bestil", fontSize = 25.sp)
            }
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