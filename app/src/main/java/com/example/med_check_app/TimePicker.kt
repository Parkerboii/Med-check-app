package com.example.med_check_app

import android.annotation.SuppressLint
import android.app.TimePickerDialog
import android.content.Context
import java.util.*

@SuppressLint("NewApi")
fun showTimePickerDialog(context: Context): String? {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val minute = calendar.get(Calendar.MINUTE)

    var selectedTime: String? = null

    val timePickerDialog = TimePickerDialog(
        context,
        { _, selectedHour, selectedMinute ->
            selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
        },
        hour,
        minute,
        true
    )

    timePickerDialog.setButton(TimePickerDialog.BUTTON_NEGATIVE, "Cancel") { dialog, _ ->
        dialog.dismiss()
    }

    timePickerDialog.show()

    return selectedTime
}
