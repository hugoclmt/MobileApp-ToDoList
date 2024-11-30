package com.example.todolist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import entity.Task
import entity.TaskList
import entity.User

class SecondMainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //configuration du edge to egde
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nomUtilisateur = intent.getStringExtra("nomUtilisateur")

        val user = User(1,nomUtilisateur.toString())
        val taskList = TaskList()
        val txtViewNomUtilisateur = findViewById<TextView>(R.id.nomUtilisateurTodoList)

        txtViewNomUtilisateur.text = "Bienvenue ${user.name}"

        val spinner: Spinner = findViewById(R.id.spinner_priority)

        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.priority_levels,
            android.R.layout.simple_spinner_item
        )
        var idTask = 0
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        val textTask = findViewById<EditText>(R.id.text_task)

        val btnaddTask = findViewById<Button>(R.id.add_task)

        var tasks = taskList.getListOfTask()







        btnaddTask.setOnClickListener {
            val textTask = textTask.text.toString()
            val selectedTaskPriority = spinner.selectedItem.toString().toInt()
            if (textTask.isNotBlank() && (selectedTaskPriority in 1..5)) {
                idTask++
                val task = Task(idTask,textTask,selectedTaskPriority)
                taskList.addTask(task)
                tasks.forEach { task ->
                    val taskDetails = "ID: ${task.id}, Description: ${task.description}, Niveau: ${task.level}, Fait: ${task.isDone}"
                    Toast.makeText(this, taskDetails, Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Veuillez remplir tout les champs",Toast.LENGTH_SHORT).show()
            }
        }


    }

}