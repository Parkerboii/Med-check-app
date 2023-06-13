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
        mutableStateListOf(
            "Paracetamol", "Morfin", "Propanolol", "Terbutalin",
            "452535", "Mgaraegegren", "325refdl", "324fewswfn",
            "86utyhgf", "fsdefgw32", "gernjke", "2fe efwfwe", "KAMLKFM", "Jnujnse"
        )
    }
    val selectedMedications = remember { mutableStateListOf<String>() }
    val medicationSelectionState = remember {
        mutableStateMapOf<String, Boolean>().apply {
            medications.forEach { medication ->
                this[medication] = false
            }
        }
    }
    var isButtonPurple by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(bottom = 100.dp)
        ) {
            items(medications) { medication ->
                val isSelected = medicationSelectionState[medication] ?: false

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            val newSelectionState = !isSelected
                            medicationSelectionState[medication] = newSelectionState

                            if (newSelectionState) {
                                selectedMedications.add(medication)
                            } else {
                                selectedMedications.remove(medication)
                            }
                            showOrderButton = selectedMedications.isNotEmpty()
                            showConfirmationButton = false
                            isButtonPurple = showOrderButton
                        }
                        .padding(8.dp)
                        .border(
                            width = 1.dp,
                            color = if (isSelected) Color(0xFF6200EE) else Color.Black,
                            shape = RoundedCornerShape(8.dp)
                        )
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = isSelected,
                            onCheckedChange = { newSelectionState ->
                                medicationSelectionState[medication] = newSelectionState

                                if (newSelectionState) {
                                    selectedMedications.add(medication)
                                } else {
                                    selectedMedications.remove(medication)
                                }
                                showOrderButton = selectedMedications.isNotEmpty()
                                showConfirmationButton = false
                                isButtonPurple = showOrderButton
                            },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(text = medication)
                    }
                    Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
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
                    tint = Color(0xFF6200EE),
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
                    backgroundColor = if (isButtonPurple) Color(0xFF6200EE) else Color.Gray,
                    contentColor = Color.White
                ),
                modifier = Modifier.width(200.dp),
                onClick = {
                    if (selectedMedications.isNotEmpty()) {
                        showConfirmationButton = true
                        showOrderButton = false
                        isButtonPurple = showOrderButton
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
                    isButtonPurple = showOrderButton
                    selectedMedications.clear()
                    medicationSelectionState.keys.forEach { medication ->
                        medicationSelectionState[medication] = false
                    }
                },
                buttons = {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        TopAppBar(
                            title = {
                                Text(text = "Valgte medikamenter")
                            },
                            backgroundColor = Color.White,
                            elevation = AppBarDefaults.TopAppBarElevation
                        )
                        Box(
                            modifier = Modifier.weight(1f)
                        ) {
                            LazyColumn(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(selectedMedications) { medication ->
                                    Text(
                                        text = "$medication : Ankomst 6/7",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp)
                                            .border(
                                                width = 1.dp,
                                                color = Color.LightGray,
                                                shape = RoundedCornerShape(8.dp)
                                            )
                                            .background(Color.White)
                                            .padding(8.dp)
                                    )
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = {
                                    showConfirmationButton = false
                                    showOrderButton = true
                                    isButtonPurple = showOrderButton
                                    selectedMedications.clear()
                                    medicationSelectionState.keys.forEach { medication ->
                                        medicationSelectionState[medication] = false
                                    }
                                }
                            ) {
                                Text("Annuller")
                            }
                            Button(
                                onClick = {
                                    showConfirmationButton = false
                                    showOrderConfirmed = true
                                    selectedMedications.clear()
                                    medicationSelectionState.keys.forEach { medication ->
                                        medicationSelectionState[medication] = false
                                    }
                                }
                            ) {
                                Text("Bekræft")
                            }
                        }
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
