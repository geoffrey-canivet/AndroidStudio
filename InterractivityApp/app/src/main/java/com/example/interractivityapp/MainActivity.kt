package com.example.interractivityapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnRecherche).setOnClickListener {
            startActivity(Intent(this, Recherche::class.java))
        }

        findViewById<Button>(R.id.btnSms).setOnClickListener {
            startActivity(Intent(this, Sms::class.java))
        }

        findViewById<Button>(R.id.btnTelephone).setOnClickListener {
            startActivity(Intent(this, Telephone::class.java))
        }
    }
}