package com.example.listes

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

        findViewById<Button>(R.id.btnListView).setOnClickListener {
            val intentFormulaire = Intent(this@MainActivity, MaListeView::class.java)
            startActivity(intentFormulaire)
        }

        findViewById<Button>(R.id.btnRecyclerView).setOnClickListener {
            val intentFormulaire = Intent(this@MainActivity, MaRecylerViewList::class.java)
            startActivity(intentFormulaire)
        }

    }
}