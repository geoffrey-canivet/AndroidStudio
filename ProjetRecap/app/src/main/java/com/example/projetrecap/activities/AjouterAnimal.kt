package com.example.projetrecap.activities

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projetrecap.R
import com.example.projetrecap.models.Animal
import com.google.gson.Gson

class AjouterAnimal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajouter_animal)

        val inputType = findViewById<EditText>(R.id.ajoutEditType)
        val inputAge = findViewById<EditText>(R.id.ajoutEditAge)
        val inputSexe = findViewById<EditText>(R.id.ajoutEditSexe)
        val inputNom = findViewById<EditText>(R.id.ajoutEditNom)
        val btnAjouter = findViewById<Button>(R.id.btnAjouter)

        inputType.hint = "Type"
        inputAge.hint = "Age"
        inputSexe.hint = "Sexe"
        inputNom.hint = "Nom"

        btnAjouter.setOnClickListener {
            val type = inputType.text.toString()
            val age = inputAge.text.toString().toInt()
            val sexe = inputSexe.text.toString()
            val nom = inputNom.text.toString()

            ajouterAnimal(type, age, sexe, nom)
        }


    }

    private fun ajouterAnimal(type: String, age: Int, sexe: String, nom: String) {
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // gestion id
        val id = sharedPreferences.getInt("id", 0)
        val newId = id + 1
        editor.putInt("id", newId)

        // Creation objet animal / transforme en json pour enregistrer dans prefs
        val animalJson = Gson().toJson(Animal(newId, type, sexe, age, nom, false))

        // enregistrer
        editor.putString(newId.toString(), animalJson)
        editor.apply()

        val intent = android.content.Intent(this, Dashboard::class.java)
        startActivity(intent)


    }





}