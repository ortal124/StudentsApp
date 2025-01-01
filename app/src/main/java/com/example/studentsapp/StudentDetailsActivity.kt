package com.example.studentsapp

import Student
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class StudentDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentNameTextView: TextView = findViewById(R.id.student_name)
        val studentIdTextView: TextView = findViewById(R.id.student_id)
        val studentImageView: ImageView = findViewById(R.id.student_image)

        val student = intent.getParcelableExtra<Student>("STUDENT_KEY")

        studentNameTextView.text = student?.name
        studentIdTextView.text = student?.id
        studentImageView.setImageResource(student?.imageResId ?: R.drawable.student_image)
    }
}
