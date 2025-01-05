package com.example.studentsapp

import Student
import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class NewStudentActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        val studentNameInput: EditText = findViewById(R.id.student_name_input)
        val studentIdInput: EditText = findViewById(R.id.student_id_input)
        val studentPhoneInput: EditText = findViewById(R.id.student_phone_input)
        val studentAddressInput: EditText = findViewById(R.id.student_address_input)
        val checkBox: CheckBox = findViewById(R.id.check_status)

        val addButton: Button = findViewById(R.id.add_student_button)

        addButton.setOnClickListener {
            val name = studentNameInput.text.toString()
            val id = studentIdInput.text.toString()
            val phone = studentPhoneInput.text.toString()
            val address = studentAddressInput.text.toString()
            val isChecked = checkBox.isChecked
            val newStudent = Student(name, id, phone, address, isChecked, R.drawable.student_image)

            StudentRepository.addStudent(newStudent)

            finish()
        }

        val cancelButton: Button = findViewById(R.id.cancel_add_student_button)

        cancelButton.setOnClickListener {
            finish()
        }
    }
}
