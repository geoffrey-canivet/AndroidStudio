package com.example.menu

import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)

        toolbar.setNavigationOnClickListener {
            Toast.makeText(this, "Navigation", Toast.LENGTH_SHORT).show()
        }

        setSupportActionBar(toolbar)

        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_item1 -> {
                    // Logique pour l'item paramètres
                    Toast.makeText(this, "item1", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.menu_item2 -> {
                    // Logique pour l'item partager
                    Toast.makeText(this, "item2", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.menu_item3 -> {
                    // Logique pour l'item partager
                    Toast.makeText(this, "item3", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return true
    }
}