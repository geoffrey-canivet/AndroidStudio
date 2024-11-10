package com.example.projetrecap.activities

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetrecap.R
import com.example.projetrecap.models.Animal
import com.example.projetrecap.models.Utilisateur
import com.google.gson.Gson

class Inscription : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inscription)

        val inputNom = findViewById<EditText>(R.id.inscriptionNom)
        val inputPrenom = findViewById<EditText>(R.id.inscriptionPrenom)
        val inputTel = findViewById<EditText>(R.id.inscriptionTel)
        val inputRole = findViewById<EditText>(R.id.inscriptionRole)
        val inputMail = findViewById<EditText>(R.id.inscriptionMail)
        val inputPass1 = findViewById<EditText>(R.id.inscriptionPass1)
        val inputPass2 = findViewById<EditText>(R.id.inscriptionPass2)
        val btnInscription = findViewById<Button>(R.id.inscriptionBtn)

        inputNom.hint = "Nom"
        inputPrenom.hint = "Prenom"
        inputTel.hint = "Telephone"
        inputRole.hint = "Role"
        inputMail.hint = "Mail"
        inputPass1.hint = "Mot de passe"
        inputPass2.hint = "Confirmation"

//        btnInscription.setOnClickListener {
//            val nom = inputNom.text.toString()
//            val prenom = inputPrenom.text.toString()
//            val tel = inputTel.text.toString()
//            val role = inputRole.text.toString()
//            val mail = inputMail.text.toString()
//            val pass1 = inputPass1.text.toString()
//            val pass2 = inputPass2.text.toString()
//
//            inscription(nom, prenom, tel, role, mail, pass1, pass2)
//
//        }
    }

//    private fun inscription(nom: String, prenom: String, tel: String, role: String, mail: String, pass1: String, pass2: String) {
//
//        if (nom.isEmpty() || prenom.isEmpty() || tel.isEmpty() || role.isEmpty() || mail.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
//            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
//        } else if (pass1 != pass2) {
//            Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show()
//        } else {
//            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//            val utilisateurJson = Gson().toJson(Utilisateur( nom + prenom, nom, prenom, tel, role, mail, pass1))
//            editor.putString(mail, utilisateurJson)
//            editor.apply()
//            val intent = android.content.Intent(this, MainActivity::class.java)
//            startActivity(intent)
//
//        }
//    }



}