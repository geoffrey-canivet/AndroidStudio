package com.example.gestioncontacts

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Website.URL
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.net.HttpURLConnection
import java.net.URL

class Info : AppCompatActivity() {
    data class Contact(val nom: String = "Nom inconnu", val tel: String = "Téléphone inconnu")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        recupInfo()
    }

    private fun recupInfo() {
        val id = intent.getIntExtra("id", 0)
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val entreeJson = sharedPreferences.getString(id.toString(), null)

        val nomTextView = findViewById<TextView>(R.id.textViewInfoNom)
        val telTextView = findViewById<TextView>(R.id.textViewInfoTel)

        val contact = Gson().fromJson(entreeJson, Contact::class.java)
        nomTextView.text = contact.nom
        telTextView.text = contact.tel

        // btn gitHub (pas besoin d'autorisation)
        val btnGitHub = findViewById<ImageView>(R.id.imageViewGitHub)
//        btnGitHub.setOnClickListener {
//            val userGitHub = contact.nom
//            val uri = "https://www.github.com/$userGitHub"
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
//            startActivity(intent)
//        }

        // btn gitHub avec API pour récuperer des infos (autorisation necessaire)
        btnGitHub.setOnClickListener {
            val user = "geoffrey-canivet"
            val url = URL("https://api.github.com/users/$user")

            Thread {
                try {
                    val connection = url.openConnection() as HttpURLConnection
                    connection.requestMethod = "GET"
                    connection.connect()

                    val responseCode = connection.responseCode
                    if (responseCode == 200) { // Code 200 : succès
                        val inputStream = connection.inputStream
                        val response = inputStream.bufferedReader().use { it.readText() }

                        // Afficher la réponse format Json
                        runOnUiThread {
                            findViewById<TextView>(R.id.textViewGitHub).text = response
                        }
                    } else {
                        Log.e("Erreur", "Erreur de connexion : $responseCode")
                    }
                } catch (e: Exception) {
                    Log.e("Exception", e.toString())
                }
            }.start()

        }

    }
}
