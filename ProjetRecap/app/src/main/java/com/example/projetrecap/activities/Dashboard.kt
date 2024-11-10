package com.example.projetrecap.activities

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projetrecap.R
import com.example.projetrecap.animalAdapter.AnimalAdapter
import com.example.projetrecap.models.Animal
import com.google.gson.Gson

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnAjouter = findViewById<Button>(R.id.dashBtnAJouter)
        btnAjouter.setOnClickListener {
            val intent = android.content.Intent(this, AjouterAnimal::class.java)
            startActivity(intent)
        }


//        val lion1 = Animal(1, "Lion", "Male", 20, "Simba", true)
//        val lion2 = Animal(2, "Lion", "Male", 20, "Simba", true)
//        val lion3 = Animal(3, "Lion", "Male", 20, "Simba", true)
//        val lion4 = Animal(4, "Lion", "Male", 20, "Simba", true)
//
//        val animalList = listOf(lion1, lion2, lion3, lion4)
//        afficherAnimaux(animalList)
        val animals: MutableList<Animal> = mutableListOf()
        recupListe(animals)

    }

    private fun recupListe(animals: MutableList<Animal>) {
        // récuperer les prefs

        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val fichierPrefs: Map<String, *> = sharedPreferences.all

        // verifier si il y a des données
        if (fichierPrefs.isNotEmpty()) {

            for ((key, value) in fichierPrefs) {
                // Debug ne pas prendre les id
                if (key != "id" ) {
                    // recuperer element json / le transformer en objet
                    val gson = Gson()
                    val animalJson = value.toString()
                    val animalObj = gson.fromJson(animalJson, Animal::class.java)
                    //ajoute a la liste
                    animals.add(animalObj)
                }
            }

            afficherListe(animals)
        } else {
            Log.d("Dash", "Pas de données")
        }

    }


    private fun afficherListe(animals: MutableList<Animal>) {
        val recyclerViewContacts = findViewById<RecyclerView>(R.id.recyclerViewAnimaux)

        recyclerViewContacts.layoutManager = LinearLayoutManager(this)

        val adapter = AnimalAdapter(this, animals)
        recyclerViewContacts.adapter = adapter
    }

}

