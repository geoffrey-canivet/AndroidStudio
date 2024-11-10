package com.example.gestionfichiers

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputText = findViewById<EditText>(R.id.editTextText)
        val btnAjouter = findViewById<Button>(R.id.btnAjouter)
        val btnRecup = findViewById<Button>(R.id.btnRecup)
        val btnSupprimer = findViewById<Button>(R.id.btnSupprimer)

        val file = File(filesDir, "mon_fichier.txt")

        // Ajouter du texte
        btnAjouter.setOnClickListener {
            // `true` permet d'ajouter du texte sans écraser
            val fileWriter = FileWriter(file, true)
            fileWriter.write(inputText.text.toString())
            fileWriter.close()
            Toast.makeText(this@MainActivity, "Bien ajouté au fichier", Toast.LENGTH_LONG).show()
        }

        // Lire le fichier
        btnRecup.setOnClickListener {
            if (file.exists()) {
                val fileReader = FileReader(file)
                val bufferedReader = BufferedReader(fileReader)
                val content = bufferedReader.readLine()
                Toast.makeText(this@MainActivity, content, Toast.LENGTH_LONG).show()
                bufferedReader.close()
            } else {
                Toast.makeText(this@MainActivity, "Le fichier n'existe pas", Toast.LENGTH_LONG).show()
            }
        }

        // Supprimer
        btnSupprimer.setOnClickListener {
            if (file.exists()) {
                file.delete()
                Toast.makeText(this@MainActivity, "Fichier supprimé", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this@MainActivity, "Fichier n'existe pas", Toast.LENGTH_LONG).show()
            }

        }
    }
}
