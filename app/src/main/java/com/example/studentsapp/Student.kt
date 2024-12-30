package com.example.studentsapp

data class Student(
    var name: String,
    var id: String,
    var isChecked: Boolean,
    val imageResId: Int // Static image resource ID
)