package com.example.gestioncontacts

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // vers activity Ajouter
        findViewById<Button>(R.id.btnActivityAjouter).setOnClickListener {startActivity(Intent(this@MainActivity, AjouterContact::class.java))}

        recupContact()

        val lien = findViewById<ImageView>(R.id.imageView2)
        lien.setOnClickListener {
            startActivity(Intent(this@MainActivity, Info::class.java))
        }


    }

    private fun recupContact() {

        // declarez liste d'objet a afficher
        val contacts: MutableList<Contact> = mutableListOf() //

        // Obtenir prefs
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

        // Récupérer toutes les entrées
        val fichierPrefs: Map<String, *> = sharedPreferences.all

        // Parcourir chaque entrée
        for ((key, value) in fichierPrefs) {
            // pour chaque entrée sauf id
            if (key != "id") {
                // transformer json en objet
                val Json = value.toString()
                val gson = Gson()
                val obj = gson.fromJson(Json , Contact::class.java)
                // Ajouter le contact dans une liste
                contacts.add(obj)
            }
        }
        // afficher
        afficher(contacts)
    }

    // afficher
    private fun afficher(liste: List<Contact>) {
        val recyclerViewContacts = findViewById<RecyclerView>(R.id.recyclerView3)

        recyclerViewContacts.layoutManager = LinearLayoutManager(this)

        val adapter = RecyclerViewAdapter(this, liste)
        recyclerViewContacts.adapter = adapter
    }

}