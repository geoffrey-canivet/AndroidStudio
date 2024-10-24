package com.example.loginsignin
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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

        // Données reçues de Formulaire (directement avec intent)
        val registeredUserName = intent.getStringExtra("userName")
        val registeredUserPass = intent.getStringExtra("userPass")
        Log.d("Main ->", "utilisateur: $registeredUserName, Pass: $registeredUserPass")

        // Connexion et envois data vers dasboard (avec API)
        // Déclaration du resultLauncher ici
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                // Récupérer les données envoyées depuis Dashboard
                val returnedData = result.data?.getStringExtra("RESULT_DATA")
                Toast.makeText(this, "Données reçues: $returnedData", Toast.LENGTH_LONG).show()
            }
        }

        btnConnexion.setOnClickListener {
            // Créer l'intent pour démarrer DashboardActivity
            val intent = Intent(this, Dashboard::class.java).apply {
                putExtra("EXTRA_DATA", "Je suis une donnée du Main")
            }
            resultLauncher.launch(intent) // Utiliser le launcher ici
        }

        // Inscription
        txtSignin.setOnClickListener {
            val intentFormulaire = Intent(this@MainActivity, Formulaire::class.java)
            startActivity(intentFormulaire)
        }

    }
}