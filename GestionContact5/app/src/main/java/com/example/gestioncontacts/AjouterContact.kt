package com.example.gestioncontacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

class AjouterContact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajouter_contact)

        val btnAjouter = findViewById<Button>(R.id.btnAjouter)
        val inputNom = findViewById<EditText>(R.id.editTextNom)
        val inputTel = findViewById<EditText>(R.id.editTextTel)
        inputNom.hint = "Nom du contact"
        inputTel.hint = "Telephone du contact"

        btnAjouter.setOnClickListener {
            saveContact(inputNom.text.toString(), inputTel.text.toString())
        }

    }
    // Ajouter un contact
    private fun saveContact(nom: String, tel: String) {
        // Obtenir l'instance des prefs
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Vérifier si les champs sont vides
        if (nom.isEmpty() || tel.isEmpty()) {
            Toast.makeText(this@AjouterContact, "Vous devez entrer un nom et un téléphone", Toast.LENGTH_SHORT).show()
            return // Sortir de la fonction
        }

        // Vérifier si le contact existe déjà
        val fichierPrefs: Map<String, *> = sharedPreferences.all
        for ((key, value) in fichierPrefs) {
            // Transformer en objet Contact
            val json = value.toString()
            val gson = Gson()
            val obj = gson.fromJson(json, Contact::class.java)

            // Si le contact existe déjà
            if (obj.nom.equals(nom)) {
                Toast.makeText(this@AjouterContact, "Le contact existe déjà", Toast.LENGTH_SHORT).show()
                return // Sortir de la fonction
            }
        }

        // si contact n existe pas
        // Récupérer ou créer un ID
        val id = sharedPreferences.getInt("id", 0)
        val newId = id + 1
        editor.putInt("id", newId)

        // Transformer en JSON pour le stocker dans SharedPreferences
        val userJson = Gson().toJson(Contact(newId, nom, tel))
        editor.putString("$newId", userJson)
        editor.apply()

        // retourner à main
        startActivity(Intent(this@AjouterContact, MainActivity::class.java))
    }
}
