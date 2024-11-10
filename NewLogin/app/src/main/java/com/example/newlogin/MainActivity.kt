package com.example.newlogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialisation de SharedPreferences
        val sharedPrefs = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

        val btnInscription = findViewById<TextView>(R.id.textView2)
        val btnConnexion = findViewById<Button>(R.id.btnConnexion)
        val inputMail = findViewById<EditText>(R.id.inputConnexionMail)
        val inputPass = findViewById<EditText>(R.id.inputConnexionPass)

        inputMail.hint = "e-mail"
        inputPass.hint = "mot de pass"


        btnConnexion.setOnClickListener {
            val userMail = inputMail.text.toString()
            val userPass = inputPass.text.toString()

            // si les champs ne sont pas vide
            if (userMail.isEmpty() || userPass.isEmpty()) {
                Toast.makeText(this, "Vous devez remplir tout les champs", Toast.LENGTH_SHORT).show()
            } else {
                // Vérifie si l'utilisateur existe déjà
                if (sharedPrefs.contains(userMail)) {
                    // si existe verif pass
                    val passOk = sharedPrefs.getString(userMail, null)
                    if (passOk == userPass) {
                        Toast.makeText(this, "utilisateur et pass ok", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@MainActivity, Profil::class.java))
                    } else {
                        Toast.makeText(this, "mdp incorrecte", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Mail n'existe pas
                    Toast.makeText(this, "Utilisateur n'existe pas", Toast.LENGTH_SHORT).show()
                }
            }
        }


        btnInscription.setOnClickListener {
            startActivity(Intent(this@MainActivity, Inscription::class.java))
        }









    }
}