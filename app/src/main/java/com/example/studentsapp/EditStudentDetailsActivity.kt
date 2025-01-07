package com.example.studentsapp

import Student
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.activity.ComponentActivity

class EditStudentDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)

        val student = intent.getParcelableExtra<Student>("STUDENT_KEY")

        val studentNameInput: EditText = findViewById(R.id.student_name_input)
        val studentIdInput: EditText = findViewById(R.id.student_id_input)
        val studentPhoneInput: EditText = findViewById(R.id.student_phone_input)
        val studentAddressInput: EditText = findViewById(R.id.student_address_input)
        val checkBox: CheckBox = findViewById(R.id.check_status)

        val saveButton: Button = findViewById(R.id.save_student_button)

        saveButton.setOnClickListener {
            val name = studentNameInput.text.toString()
            val id = studentIdInput.text.toString()
            val phone = studentPhoneInput.text.toString()
            val address = studentAddressInput.text.toString()
            val isChecked = checkBox.isChecked
            val updatedStudent = Student(name, id, phone, address, isChecked, R.drawable.student_image)


            StudentRepository.updateStudent(student!!, updatedStudent)
            val resultIntent = Intent()
            resultIntent.putExtra("updatedStudent", updatedStudent)
            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }

        val cancelButton: Button = findViewById(R.id.cancel_edit_button)

        cancelButton.setOnClickListener {
            finish()
        }

        val deleteButton: Button = findViewById(R.id.delete_student_button)

        deleteButton.setOnClickListener {
            StudentRepository.deleteStudent(student!!)

            // Signal that the student was deleted
            val resultIntent = Intent()
            resultIntent.putExtra("isDeleted", true)
            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        }
    }
}
