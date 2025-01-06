package com.example.studentsapp

import Student

object StudentRepository {
    private val students = mutableListOf<Student>()

    fun getStudents(): List<Student> = students

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun updateStudent(oldStudent: Student, updatedStudent: Student) {
        val index = students.indexOf(oldStudent)
        if (index != -1) {
            students[index] = updatedStudent
        }
    }

    fun deleteStudent(student: Student) {
        val index = students.indexOf(student)
        if (index != -1) {
            students.removeAt(index)
        }
    }
}
