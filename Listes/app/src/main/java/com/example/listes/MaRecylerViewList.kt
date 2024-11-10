package com.example.listes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MaRecylerViewList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ma_recyler_view_list)

        val myRecyclerView = findViewById<RecyclerView>(R.id.recyclerView1)

        // type de layout GridLayoutManager - StaggeredGridLayoutManager - LinearLayoutManager
        myRecyclerView.layoutManager = LinearLayoutManager(this)




        val data = List(20) {
                index -> "Element ${index + 1}"
        }

        val adapter = CustomAdapter(data)
        myRecyclerView.adapter = adapter


    }

//    val prenoms = listOf("Prenom1", "Prenom2", "Prenom3", "Prenom4", "Prenom5")
//    val noms = listOf("Nom1", "Nom2", "Nom3", "Nom4", "Nom5")
//
//    val data = List(10) {
//        generateRandomPerson(prenoms, noms).toString()
//    }
//
//    private fun generateRandomPerson(prenoms: List<String>, noms: List<String>): Person {
//        return Person("${prenoms.random()} ${noms.random()}", generatePhoneNumber())
//    }
//
//    private fun generatePhoneNumber(): String {
//        val phoneNumber = (1..4).joinToString(" ") {
//            (Random.nextInt(10, 99)).toString()
//        }
//        return "04 $phoneNumber"
//    }
}