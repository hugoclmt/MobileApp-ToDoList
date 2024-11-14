package com.example.todolist

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        val txtViewNomUtilisateur = findViewById<TextView>(R.id.nomUtilisateurTodoList)

        txtViewNomUtilisateur.text = "Bienvenue ${user.name}"

    }

}