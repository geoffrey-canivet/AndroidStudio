package com.example.interractivityapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Recherche : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche)

        findViewById<EditText>(R.id.editTextItemRecherche).hint = "Votre recherche ici..."

        findViewById<Button>(R.id.btnRechercher).setOnClickListener {
            rechercher()
        }
    }

    private fun rechercher() {
        val recherche = findViewById<EditText>(R.id.editTextItemRecherche).text.toString()
        val uri = "https://www.google.com/search?q=$recherche"
        Log.d("TAG", "$uri")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }



}