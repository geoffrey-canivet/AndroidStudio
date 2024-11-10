package com.example.crud.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.dao.UserDAO
import com.example.crud.R
import com.example.crud.adapters.UserAdapter
import com.example.crud.models.User

class MainActivity : AppCompatActivity() {

    private lateinit var userDAO: UserDAO // Déclaration de userDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userDAO = UserDAO(this) // Initialisation de userDAO

        val inputNom = findViewById<EditText>(R.id.editTextNom)
        val inputPrenom = findViewById<EditText>(R.id.editTextprenom)
        val inputRn = findViewById<EditText>(R.id.editTextRn)
        val btnAjouter = findViewById<Button>(R.id.btnAjouter)
        val btnModifier = findViewById<Button>(R.id.btnModifier)
        val btnSupprimer = findViewById<Button>(R.id.btnSupprimer)

        recupUser()
        afficherTousLesUtilisateurs()

        btnAjouter.setOnClickListener {
            val nom = inputNom.text.toString()
            val prenom = inputPrenom.text.toString()
            val rn = inputRn.text.toString()
            ajouterUtilisateur(nom, prenom, rn)
        }

        btnModifier.setOnClickListener {

        }

    }


    private fun ajouterUtilisateur(nom: String, prenom: String, rn: String){

        val newUser = User(lastname = nom, firstname = prenom, regNat = rn)

        userDAO.openWritable()
        userDAO.insert(newUser)
        userDAO.close()
        recupUser()
        Toast.makeText(this, "Utilisateur ajouté avec succès!", Toast.LENGTH_SHORT).show()

    }

    // afficher la recyclerView
    private fun recupUser() {
        userDAO.openReadable() // Ouvrir la base de données en mode lecture
        val utilisateurs = userDAO.getAll() // Récupérer tous les utilisateurs
        userDAO.close() // Fermer la base de données

        if (utilisateurs.isNotEmpty()) {
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView2)
            recyclerView.layoutManager = LinearLayoutManager(this)

            // Convertir la liste en MutableList pour la passer à l'adaptateur
            val adapter = UserAdapter(utilisateurs.toMutableList())
            recyclerView.adapter = adapter
        } else {
            Log.d("Utilisateur", "Aucun utilisateur trouvé dans la base de données.")
        }
    }









    // LOG
    private fun afficherTousLesUtilisateurs() {
        userDAO.openReadable() // Ouvrir la base de données en mode lecture
        val utilisateurs = userDAO.getAll() // Récupérer tous les utilisateurs
        userDAO.close() // Fermer la base de données

        if (utilisateurs.isNotEmpty()) {
            utilisateurs.forEach { user ->
                // Afficher chaque utilisateur dans Logcat
                Log.d("Utilisateur", "ID: ${user.id}, Nom: ${user.lastname}, Prénom: ${user.firstname}, RegNat: ${user.regNat}")
            }
        } else {
            Log.d("Utilisateur", "Aucun utilisateur trouvé dans la base de données.")
        }
    }





}