import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.med_check_app.showTimePickerDialog
import java.util.*

@SuppressLint("UnrememberedMutableState")
@Composable
fun ReminderContentButtons() {
    val tasks = remember { mutableStateListOf("Paracetamol", "Morfin", "Propanolol", "Terbutalin") }
    var selectedItem by remember { mutableStateOf("") }
    var isTimePickerVisible by remember { mutableStateOf(false) }
    var selectedTime by remember { mutableStateOf("") }
    var isAlertDialogVisible by remember { mutableStateOf(false) }
    var selectedFrequency by remember { mutableStateOf("") }

    val frequencyOptions = arrayOf("Vælg", "4 gange om dagen", "3 gange om dagen",
        "2 gange om dagen", "Hver dag", "Hver 2 dag", "Hver 3 dag",
        "Hver 4 dag", "Hver 5 dag", "Hver 6 dag", "Hver 7 dag")

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
                        isAlertDialogVisible = true
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

    if (isAlertDialogVisible) {
        val spinner = createSpinner(context, frequencyOptions, selectedFrequency)

        AlertDialog.Builder(context)
            .setTitle("Gentagelser")
            .setView(spinner)
            .setPositiveButton("Fortsæt") { _, _ ->
                selectedFrequency = frequencyOptions[spinner.selectedItemPosition]
                isAlertDialogVisible = false
                isTimePickerVisible = true
            }
            .setNegativeButton("Annuller") { _, _ ->
                isAlertDialogVisible = false
            }
            .show()
    }

    if (isTimePickerVisible) {
        LaunchedEffect(isTimePickerVisible) {
            val time = showTimePickerDialog(context)
            if (time != null) {
                selectedTime = time
            }
            isTimePickerVisible = false
        }
    }
}

@Composable
private fun createSpinner(context: Context, options: Array<String>, selectedItem: String): Spinner {
    val spinner = remember { Spinner(context) }
    val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, options)
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    spinner.adapter = adapter
    spinner.setSelection(options.indexOf(selectedItem))
    return spinner
}
