package com.example.med_check_app.data

import java.time.LocalDateTime

data class Reminder(
    val title: String,
    val description: String,
    val dateTime: LocalDateTime
)
