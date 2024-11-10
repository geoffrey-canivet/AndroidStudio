package com.example.loginsignin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val button = findViewById<Button>(R.id.btnRecupDataMain)

        // Récupérer la donnée envoyée depuis MainActivity (API)
        val data = intent.getStringExtra("EXTRA_DATA")

        button.setOnClickListener {
            // Afficher la donnée dans un Toast
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()

            // Renvoie la donnée à MainActivity
//            val resultIntent = Intent().apply {
//                putExtra("RESULT_DATA", data)
//            }
//            setResult(RESULT_OK, resultIntent)
//            finish()
        }
    }
}