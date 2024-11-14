package com.example.todolist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import entity.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //configuration du edge to egde
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTxtUser = findViewById<EditText>(R.id.editTxtUserName)
        val btnValidateAccueil = findViewById<Button>(R.id.btnValiderAccueil)

        btnValidateAccueil.setOnClickListener {
            val nomUtilisateur = editTxtUser.text.toString()
            if (nomUtilisateur.isNotBlank()) {
                val itent = Intent(this,SecondMainActivity::class.java)
                itent.putExtra("nomUtilisateur", nomUtilisateur)
                startActivity(itent)
            }else{
                Toast.makeText(this,"Veuillez remplir le champ",Toast.LENGTH_SHORT).show()
            }
        }

    }
}