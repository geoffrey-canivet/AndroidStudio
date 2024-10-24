package com.example.loginutilisateur

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Creation toast
        val app = application as Gestion
        val toastValeur = app.toastMessage
        Toast.makeText(this@MainActivity, toastValeur, Toast.LENGTH_LONG).show()




        //Input
        val inputNom = findViewById<EditText>(R.id.inputNom)
        inputNom.hint = "Nom utilisateur"
        val inputPass = findViewById<EditText>(R.id.inputPass)
        inputPass.hint = "Mot de passe"

        // Btn connexion
        val btnConnexion = findViewById<Button>(R.id.btnConnexion)
        btnConnexion.setOnClickListener {
            val nom = inputNom.text.toString()
            val pass = inputPass.text.toString()
            Log.d("MainActivity", "Nom: $nom, Pass: $pass")
        }

        // Btn reset
        val btnReset = findViewById<Button>(R.id.btnReste)
        btnReset.setOnClickListener {
            inputNom.setText("")
            inputPass.setText("")
        }









    }
}