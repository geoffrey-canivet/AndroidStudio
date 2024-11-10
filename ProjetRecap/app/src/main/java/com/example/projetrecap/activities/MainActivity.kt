package com.example.projetrecap.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetrecap.R
import com.example.projetrecap.models.Utilisateur
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConnexion = findViewById<Button>(R.id.mainBtnConnexion)
        val btnInscription = findViewById<TextView>(R.id.mainBtnInscription)
        val inputMail = findViewById<EditText>(R.id.mainInputMail)
        val inputPass = findViewById<EditText>(R.id.mainInputPass)
        val checkBox = findViewById<TextView>(R.id.mainCheckBox)



        btnInscription.setOnClickListener {
            val intent = Intent(this, Inscription::class.java)
            startActivity(intent)

        }

        btnConnexion.setOnClickListener {
//            val mail = inputMail.text.toString()
//            val pass = inputPass.text.toString()
//            connexion(mail, pass)
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

    }

//    private fun connexion(mail: String, pass: String) {
//
//        if (mail.isEmpty() || pass.isEmpty()) {
//            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
//        } else {
//            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
//
//
//            if (sharedPreferences.contains(mail)) {
//                val utilisateurJson = sharedPreferences.getString(mail, null)
//                val gson = Gson()
//                val utilisateurObj = gson.fromJson(utilisateurJson, Utilisateur::class.java)
//                Log.d("MAIN", "${utilisateurObj.password}")
//
//                if (utilisateurObj.password == pass) {
//                    Log.d("MAIN", "connexion reussie")
//                    val intent = Intent(this@MainActivity, Dashboard::class.java)
//                    startActivity(intent)
//                } else {
//                    Toast.makeText(this, "Mot de passe incorrect", Toast.LENGTH_SHORT).show()
//                }
//            } else {
//                Toast.makeText(this, "Email inconnu", Toast.LENGTH_SHORT).show()
//
//            }
//        }
//    }





}


