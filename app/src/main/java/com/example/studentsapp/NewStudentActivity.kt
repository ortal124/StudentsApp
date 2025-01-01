package com.example.studentsapp

import Student
import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class NewStudentActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val studentNameInput: EditText = findViewById(R.id.student_name_input)
        val studentIdInput: EditText = findViewById(R.id.student_id_input)
        val addButton: Button = findViewById(R.id.add_student_button)

        addButton.setOnClickListener {
            val name = studentNameInput.text.toString()
            val id = studentIdInput.text.toString()

            val newStudent = Student(name, id, false, R.drawable.student_image)

            StudentRepository.addStudent(newStudent)

            finish()
        }
    }
}
