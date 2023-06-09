import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ReminderContentButtons() {
    val tasks = remember { mutableStateListOf("Paracetamol", "Morfin", "Paracetamol") }
    var selectedItem by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        tasks.forEachIndexed { index, task ->
            var isChecked by remember { mutableStateOf(false) }

            Column(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f),
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(8.dp)
                    .width(335.dp)
                    .clickable {
                        selectedItem = task
                    }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = { isChecked = it },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = task)
                }
            }
        }
    }

    if (selectedItem.isNotEmpty()) {
        AlertDialog(
            onDismissRequest = { selectedItem = "" },
            title = { Text(text = "Selected Item") },
            text = { Text(text = "You clicked on: $selectedItem") },
            confirmButton = {
                Button(onClick = { selectedItem = "" }) {
                    Text(text = "OK")
                }
            },
            properties = DialogProperties(dismissOnClickOutside = false)
        )
    }
}

