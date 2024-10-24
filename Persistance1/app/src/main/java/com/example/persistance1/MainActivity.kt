package com.example.persistance1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputMail = findViewById<EditText>(R.id.editEmail)
        val inputPass = findViewById<EditText>(R.id.editPassword)
        val btnConnexion = findViewById<Button>(R.id.btnLogin)

        btnConnexion.setOnClickListener {
            val email = inputMail.text.toString()
            val pass = inputPass.text.toString()

            saveData(email, pass)
            afficheData()

            val intent = Intent(this@MainActivity, Profil::class.java)
            startActivity(intent)
        }

        afficheData()

    }

        fun saveData(data1: String, data2: String) {
            // Crée un fichier dans le télépphone pour les préférances Ou le récupérer
            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

            // Creer / modifier / sauvegarder des données
            val editor = sharedPreferences.edit()
            editor.putString("username", data1)
            editor.putString("pass", data2)
            editor.apply()
        }

        fun afficheData() {
            // Récupérer les prefs
            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            // preciser la pref
            val userName = sharedPreferences.getString("username", "")
            val userPass = sharedPreferences.getString("pass", "")
            // afficher si existe
            if (sharedPreferences != null) {
                Log.d("recup de Main", "$userName $userPass")
            } else {
                Log.d("recup de Main", "pas de data")
            }
        }

}