package com.example.studentsapp

object StudentRepository {
    private val students = mutableListOf<Student>()

    fun getStudents(): List<Student> = students

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(position: Int, student: Student) {
        students[position] = student
    }

    fun deleteStudent(position: Int) {
        students.removeAt(position)
    }
}
