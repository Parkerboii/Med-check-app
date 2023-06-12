/*package com.example.med_check_app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MedicinContent() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()){
        Text(text = "MedicinPage", fontSize = 50.sp)
    }
}
@Composable
fun MedicinPage() {
    Scaffold(
        topBar = { MedicinTopBar() },
        content = { MedicinContent() }
    )
}
@Composable
fun MedicinTopBar() {
    TopAppBar(title = {
        Text(
            text = "Medicin",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,

            )
    })
}

 */
package com.example.med_check_app

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
/*
@Composable
fun MedicinContent() {
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("") }
    var textFieldValue by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = { isDropdownExpanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Option 1"
                    isDropdownExpanded = false
                },
                modifier = Modifier.width(1000.dp) // Set the width as desired
            ) {
                Text(text = "Option 1")
            }
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Option 2"
                    isDropdownExpanded = false
                },
                modifier = Modifier.width(1000.dp) // Set the width as desired
            ) {
                Text(text = "Option 2")
            }
        }

        Button(
            onClick = { isDropdownExpanded = true },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = if (selectedOption.isNotBlank()) selectedOption else "Medicament")
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
        }
    }
}
*/
@Composable
fun MedicinContent() {
    var selectedOption by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top, // Align buttons at the top
        modifier = Modifier.fillMaxSize()
    ) {
        Button(
            onClick = {
                if (selectedOption == "Paracetamol: Til voksne er den sædvanlige dosis 2 tabletter (1 gram) 3-4 gange dagligt. Hvis du har konstante smerter, anbefaler vi, at du tager dine tabletter i faste doser fordelt over døgnets timer.") {
                    selectedOption = ""
                } else {
                    selectedOption =
                        "Paracetamol: Til voksne er den sædvanlige dosis 2 tabletter (1 gram) 3-4 gange dagligt. Hvis du har konstante smerter, anbefaler vi, at du tager dine tabletter i faste doser fordelt over døgnets timer."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Paracetamol")
        }

        Button(
            onClick = {
                if (selectedOption == "Morfin: Morfin og andre opioider kan påvirke ens hukommelses- og koncentrationsevne, og man kan blive konfus eller døsig. Man kan også opleve hudkløe, sved, mundtørhed og svimmelhed.") {
                    selectedOption = ""
                } else {
                    selectedOption =
                        "Morfin: Morfin og andre opioider kan påvirke ens hukommelses- og koncentrationsevne, og man kan blive konfus eller døsig. Man kan også opleve hudkløe, sved, mundtørhed og svimmelhed."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Morfin")
        }

        Button(
            onClick = {
                if (selectedOption == "Propanolol: Propranolol bruges mod mod forhøjet blodtryk. mod hjerterytmeforstyrrelser. til forebyggelse af hjertekrampe. forebyggende til personer, der har haft en blodprop i hjertet.") {
                    selectedOption = ""
                } else {
                    selectedOption =
                        "Propanolol: Propranolol bruges mod mod forhøjet blodtryk. mod hjerterytmeforstyrrelser. til forebyggelse af hjertekrampe. forebyggende til personer, der har haft en blodprop i hjertet."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Propanolol ")
        }

        Button(
            onClick = {
                if (selectedOption == "Terbutalin: Den virker ved at afslappe og udvide musklerne rundt om dine luftveje, som gør det muligt for dem at åbne op. Dette hjælper dig med lettere at trække vejret.") {
                    selectedOption = ""
                } else {
                    selectedOption =
                        "Terbutalin: Den virker ved at afslappe og udvide musklerne rundt om dine luftveje, som gør det muligt for dem at åbne op. Dette hjælper dig med lettere at trække vejret."
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Terbutalin")
        }

        if (selectedOption.isNotBlank()) {
            TextField(
                value = selectedOption,
                onValueChange = { /* No-op */ },
                label = { Text(text = "Medicin forklaring") },
                readOnly = true,
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }
    }
}




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicinPage() {
    Scaffold(
        topBar = { MedicinTopBar() },
        content = { MedicinContent() }
    )
}

@Composable
fun MedicinTopBar() {
    TopAppBar(title = {
        Text(
            text = "Medicin",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )
    })
}
