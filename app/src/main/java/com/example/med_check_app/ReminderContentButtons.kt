import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.*

@SuppressLint("UnrememberedMutableState")
@Composable
fun ReminderContentButtons() {
    val tasks = remember { mutableStateListOf("Paracetamol", "Morfin", "Paracetamol") }
    var selectedItem by remember { mutableStateOf("") }
    var isTimePickerVisible by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }

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
                        isTimePickerVisible = true
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

    val context = LocalContext.current

    if (isTimePickerVisible) {
        showTimePickerDialog(context) { time ->
            selectedTime = time
            isTimePickerVisible = false
        }
    }
}

@SuppressLint("NewApi")
fun showTimePickerDialog(context: Context, onTimeSelected: (String) -> Unit) {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    val timePickerDialog = TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            val time = String.format("%02d:%02d", selectedHour, selectedMinute)
            onTimeSelected(time)
        },
        hour,
        minute,
        true
    )

    timePickerDialog.show()
}
