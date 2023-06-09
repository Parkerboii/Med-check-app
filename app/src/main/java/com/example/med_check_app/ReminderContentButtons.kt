import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ReminderContentButtons(){
    val tasks = remember { mutableStateListOf("Paracetamol", "Morfin", "Paracetamol") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
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
                    .width(335.dp)
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
