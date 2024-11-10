package com.example.newlogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Inscription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        val inputMail = findViewById<EditText>(R.id.inputInscriptionMail)
        val inputPass = findViewById<EditText>(R.id.inputInscriptionPass)
        val btnInscription = findViewById<Button>(R.id.btnInscription)
        val btnReset = findViewById<TextView>(R.id.btnReset2)

        // Initialisation de SharedPreferences
        val sharedPrefs = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

        btnInscription.setOnClickListener {
            val userMail = inputMail.text.toString()
            val userPass = inputPass.text.toString()

            // Vérifie si l'utilisateur existe déjà
            if (sharedPrefs.contains(userMail)) {
                Toast.makeText(this, "Cet e-mail est déjà enregistré", Toast.LENGTH_SHORT).show()
            } else {
                // Ajoute l'utilisateur dans SharedPreferences
                val editor = sharedPrefs.edit()
                editor.putString(userMail, userPass)
                editor.apply() // Sauvegarde les modifications
                Toast.makeText(this, "Inscription réussie", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@Inscription, MainActivity::class.java))
            }
        }

        btnReset.setOnClickListener {
            // Réinitialise les champs d'inscription
            inputMail.text.clear()
            inputPass.text.clear()
        }
    }
}
