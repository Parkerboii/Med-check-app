package com.example.med_check_app

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.platform.LocalContext

@Composable
fun ReminderContentButtons() {
    val context = LocalContext.current

    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = "Androidly Alert") },
        text = { Text(text = "We have a message") },
        confirmButton = {
            Button(onClick = {
                Toast.makeText(context, android.R.string.yes, Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(onClick = {
                Toast.makeText(context, android.R.string.no, Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "No")
            }
        },
        neutralButton = {
            Button(onClick = {
                Toast.makeText(context, "Maybe", Toast.LENGTH_SHORT).show()
            }) {
                Text(text = "Maybe")
            }
        }
    )
}