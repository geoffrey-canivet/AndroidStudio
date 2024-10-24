package com.example.phone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMenuPhone = findViewById<Button>(R.id.btnMenuTel)

        btnMenuPhone.setOnClickListener {
            val intentMenuTelephone = Intent(this@MainActivity, Telephone::class.java)
            startActivity(intentMenuTelephone)
        }

        val btnMenuRecherche = findViewById<Button>(R.id.btnMenuRecherche)

        btnMenuRecherche.setOnClickListener {
            val intentMenuTelephone = Intent(this@MainActivity, Recherche::class.java)
            startActivity(intentMenuTelephone)
        }

        val btnAlarme = findViewById<Button>(R.id.btnAlarme)

        btnAlarme.setOnClickListener {
            ouvrirCalendrier()
        }

    }


    private fun ouvrirCalendrier() {
        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_APP_CALENDAR)
        }
        startActivity(intent)
    }

}