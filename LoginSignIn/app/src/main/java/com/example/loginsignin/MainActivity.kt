package com.example.loginsignin
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConnexion = findViewById<Button>(R.id.btnConnexion)
        val inputNom = findViewById<EditText>(R.id.inputNom)
        val inputPass = findViewById<EditText>(R.id.inputPass)
        val txtSignin = findViewById<TextView>(R.id.txtSignIn)

        inputNom.hint = "Nom d'utilisateur"
        inputPass.hint = "Mot de pass"

        // Données reçues de Formulaire
        val registeredUserName = intent.getStringExtra("userName")
        val registeredUserPass = intent.getStringExtra("userPass")
        Log.d("Main ->", "utilisateur: $registeredUserName, Pass: $registeredUserPass")

        // Gestion de la connexions
        btnConnexion.setOnClickListener {
            val intentDashboard = Intent(this@MainActivity, Dashboard::class.java)
            startActivity(intentDashboard)
        }

        // Inscription
        txtSignin.setOnClickListener {
            val intentFormulaire = Intent(this@MainActivity, Formulaire::class.java)
            startActivity(intentFormulaire)
        }

    }
}