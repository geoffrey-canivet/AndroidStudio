package com.example.projetrecap.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.projetrecap.R

class FicheAnimal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiche_animal)

        val id = intent.getStringExtra("id")
        val type = intent.getStringExtra("type")
        val nom = intent.getStringExtra("nom")
        val age = intent.getStringExtra("age")
        val sexe = intent.getStringExtra("sexe")
        val isFed = intent.getStringExtra("isFed")

        val nomAnimal = findViewById<TextView>(R.id.nomAnimal)
        val inputId = findViewById<TextView>(R.id.ficheId)
        val inputType = findViewById<TextView>(R.id.ficheType)
        val inputNom = findViewById<TextView>(R.id.ficheNom)
        val inputAge = findViewById<TextView>(R.id.ficheAge)
        val inputSexe = findViewById<TextView>(R.id.ficheSexe)
        val inputIsFed = findViewById<TextView>(R.id.ficheNourri)
        val imgAnimal = findViewById<ImageView>(R.id.imgAnimal)
        val btnNourrir = findViewById<TextView>(R.id.button)
        val btnRetour = findViewById<TextView>(R.id.button2)

        nomAnimal.text = nom
        inputId.text = id
        inputType.text = type
        inputNom.text = nom
        inputAge.text = age
        inputSexe.text = sexe
        inputIsFed.text = isFed

        afficheImage(type.toString(), imgAnimal)

        btnNourrir.setOnClickListener {

        }

        btnRetour.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

    }

    private fun afficheImage(type: String, imgAnimal: ImageView) {
        when (type) {
            "Lion" -> imgAnimal.setImageResource(R.drawable.lion)
            "Crocodile" -> imgAnimal.setImageResource(R.drawable.crocodile)
            "Cheval" -> imgAnimal.setImageResource(R.drawable.cheval)
            "Koala" -> imgAnimal.setImageResource(R.drawable.koala)
            "Lapin" -> imgAnimal.setImageResource(R.drawable.lapin)
            "Tigre" -> imgAnimal.setImageResource(R.drawable.tigre)
            "Phacochere" -> imgAnimal.setImageResource(R.drawable.phacochere)
            "rene" -> imgAnimal.setImageResource(R.drawable.rene)
            "pingouin" -> imgAnimal.setImageResource(R.drawable.pinguin)
            else -> imgAnimal.setImageResource(R.drawable.cheval)
        }
    }


}