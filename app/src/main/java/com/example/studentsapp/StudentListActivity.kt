package com.example.studentsapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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

        val addButton: FloatingActionButton = findViewById(R.id.fab_add_student)

        addButton.setOnClickListener {
            val intent = Intent(this, NewStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Refresh the data and notify the adapter
        adapter.notifyDataSetChanged()
    }
}
