package com.example.interractivityapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Telephone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telephone)

        findViewById<EditText>(R.id.editTextNumeroTel).hint = "Numero de telephone"

        findViewById<Button>(R.id.btnTelephoner).setOnClickListener {
            telephoner()
        }
    }

    private fun telephoner() {
        val numero = findViewById<EditText>(R.id.editTextNumeroTel).text.toString()

        // Permission du manifest
        val telPermission = Manifest.permission.CALL_PHONE
        // Verif permission du manifest
        val appPermission = ContextCompat.checkSelfPermission(this@Telephone, telPermission)
        // verifie si utilisateur a donné autorisation
        val accordee = PackageManager.PERMISSION_GRANTED

        // verif permission
        if (appPermission != accordee) {
            // si pas accordée demander permission via un dialogue
            ActivityCompat.requestPermissions(this@Telephone, arrayOf(telPermission), 1)
        } else {
            // si accordée passer un appel
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$numero")
            }

            // Si app dispo dans le tel pour passer un appel
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            }
        }
    }
}