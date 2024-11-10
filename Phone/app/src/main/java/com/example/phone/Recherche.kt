package com.example.phone
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Recherche : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche)


        val btnRechercher = findViewById<Button>(R.id.btnRechercher)

        btnRechercher.setOnClickListener {
            openWebPage()
            Log.d("activity_recherche", "le clique est bon")
        }

    }

    fun openWebPage() {
        val uri = "https://www.google.com/"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }

}