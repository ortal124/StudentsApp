package com.example.studentsapp

import Student
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity

class StudentDetailsActivity : ComponentActivity() {
    val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val student = intent.getParcelableExtra<Student>("STUDENT_KEY")

        initStudentDetails(student!!)

        val editButton: Button = findViewById(R.id.edit_student_button)

        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentDetailsActivity::class.java)
            intent.putExtra("STUDENT_KEY", student)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val isDeleted = data?.getBooleanExtra("isDeleted", false) ?: false
            if (isDeleted) {
                finish()
            } else {
                val updatedStudent = data?.getParcelableExtra<Student>("updatedStudent")
                if (updatedStudent != null ) {
                    initStudentDetails(updatedStudent)
                }
            }
        }
    }

    fun initStudentDetails(student: Student) {
        val studentNameTextView: TextView = findViewById(R.id.student_name)
        val studentIdTextView: TextView = findViewById(R.id.student_id)
        val studentImageView: ImageView = findViewById(R.id.student_image)
        val studentPhoneView: TextView = findViewById(R.id.student_phone)
        val studentAddressView: TextView = findViewById(R.id.student_address)
        val studentCheckView: CheckBox = findViewById(R.id.check_status)

        student?.let {
            // Update the UI with the new student details
            studentNameTextView.text = it.name
            studentIdTextView.text = it.id
            studentPhoneView.text = it.phone
            studentAddressView.text = it.address
            studentCheckView.isChecked = it.isChecked
            studentImageView.setImageResource(it.imageResId ?: R.drawable.student_image)
        }
    }
}
