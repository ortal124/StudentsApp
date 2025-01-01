package com.example.studentsapp

import Student
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val studentList: MutableList<Student>, private val onItemClick: (Student) -> Unit) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val studentImage: ImageView = itemView.findViewById(R.id.student_image)
        val studentName: TextView = itemView.findViewById(R.id.student_name)
        val studentId: TextView = itemView.findViewById(R.id.student_id)
        val checkBox: CheckBox = itemView.findViewById(R.id.check_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentList[position]
        holder.studentName.text = student.name
        holder.studentId.text = student.id
        holder.studentImage.setImageResource(student.imageResId)
        holder.checkBox.isChecked = student.isChecked

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            student.isChecked = isChecked
        }

        holder.itemView.setOnClickListener {
            onItemClick(student)
        }
    }

    override fun getItemCount(): Int = studentList.size
}
