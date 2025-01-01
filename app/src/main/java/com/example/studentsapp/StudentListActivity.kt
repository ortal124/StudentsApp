package com.example.studentsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StudentsListActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_list)

        recyclerView = findViewById(R.id.students_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Sample static data
        val students = StudentRepository.getStudents()

        adapter = StudentAdapter(students) { student ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("STUDENT_KEY", student)
            startActivity(intent)
        }

        recyclerView.adapter = adapter
    }
}
