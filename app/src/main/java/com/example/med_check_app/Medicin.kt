import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.med_check_app.data.DataViewModel

@Composable
fun MedicinContent(dataViewModel: DataViewModel = viewModel()) {
    var selectedOption by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(bottom = 100.dp)
        ) {
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Paracetamol"
                            dataViewModel.getData(selectedOption)
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Paracetamol") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Paracetamol",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Paracetamol") {
                    TextField(
                        value = dataViewModel.state.value.Description,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Morfin"
                            dataViewModel.getData(selectedOption)
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Morfin") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Morfin",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Morfin") {
                    TextField(
                        value = dataViewModel.state.value.Description,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Propanolol"
                            dataViewModel.getData(selectedOption)
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Propanolol") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Propanolol",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Propanolol") {
                    TextField(
                        value = dataViewModel.state.value.Description,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable {
                            selectedOption = "Terbutalin"
                            dataViewModel.getData(selectedOption)
                        },
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, if (selectedOption == "Terbutalin") Color(0xFF6200EE) else Color.Gray)
                ) {
                    Text(
                        text = "Terbutalin",
                        fontSize = 20.sp,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                if (selectedOption == "Terbutalin") {
                    TextField(
                        value = dataViewModel.state.value.Description,
                        onValueChange = { /* No-op */ },
                        label = { Text(text = "Medicin forklaring") },
                        readOnly = true,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
        if (selectedOption.isNotEmpty()){
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        selectedOption = ""
                    }
            )
        }
    }
}

@Composable
fun MedicinTopBar() {
    TopAppBar(title = {
        Text(
            text = "Medicin Information",
            style = MaterialTheme.typography.h6,
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
        )
    })
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MedicinPage() {
    Scaffold(
        topBar = { MedicinTopBar() },
        content = { MedicinContent() }
    )
}
