package com.example.studentsapp

import Student
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentDetailsActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val studentNameTextView: TextView = findViewById(R.id.student_name)
        val studentIdTextView: TextView = findViewById(R.id.student_id)
        val studentImageView: ImageView = findViewById(R.id.student_image)
        val studentPhoneView: TextView = findViewById(R.id.student_phone)
        val studentAddressView: TextView = findViewById(R.id.student_address)
        val studentCheckView: CheckBox = findViewById(R.id.check_status)

        val student = intent.getParcelableExtra<Student>("STUDENT_KEY")

        studentNameTextView.text = student?.name
        studentIdTextView.text = student?.id
        studentPhoneView.text = student?.phone
        studentAddressView.text = student?.address
        studentCheckView.isChecked = student?.isChecked == true
        studentImageView.setImageResource(student?.imageResId ?: R.drawable.student_image)

        val editButton: Button = findViewById(R.id.edit_student_button)

        editButton.setOnClickListener {
            val intent = Intent(this, EditStudentDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}
