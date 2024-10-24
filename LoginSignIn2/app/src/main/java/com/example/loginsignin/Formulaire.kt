package com.example.loginsignin
import android.content.Intent
import android.widget.TextView
import android.widget.Button
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Formulaire : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulaire)

        val intentMain = Intent(this@Formulaire, MainActivity::class.java)

        val btnRetour = findViewById<Button>(R.id.btnRetour)
        val btnEnregistrer = findViewById<Button>(R.id.btnEnregistrer)
        val inputRegisterNom = findViewById<EditText>(R.id.inputRegisterNom)
        val inputRegisterPass = findViewById<EditText>(R.id.inputRegisterPass)

        inputRegisterPass.hint = "Mot de pass"
        inputRegisterNom.hint = "Utilisateur"

        btnEnregistrer.setOnClickListener {

            // Valeur a envoyer au Main (directement avec intent)
            val userName = inputRegisterNom.text.toString()  // Convertir en String
            val userPass = inputRegisterPass.text.toString()
            // Ajouter les informations utilisateur et mot de passe à l'Intent
            intentMain.putExtra("userName", userName)
            intentMain.putExtra("userPass", userPass)

            startActivity(intentMain)
        }

        btnRetour.setOnClickListener {
            startActivity(intentMain)
        }



    }
}