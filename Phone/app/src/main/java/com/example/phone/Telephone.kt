package com.example.phone

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.Manifest as Android

class Telephone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telephone)



        val btnTelephoner = findViewById<Button>(R.id.btnTelephoner)

        btnTelephoner.setOnClickListener {
            telephoner("123456789")
        }
    }

//    val numeo = "123456789"

    // A l'installation demande a l'utilisateur la permission d appeler. appel directement sans confirmation avec btn appeler
    // Définition d'une fonction pour passer un appel avec un numéro de téléphone en paramètre
    private fun telephoner(numero: String) {

        // Déclare la permission nécessaire pour passer des appels téléphoniques
        val telPermission = Android.permission.CALL_PHONE

        // Vérifie si l'application a déjà la permission CALL_PHONE
        // `checkSelfPermission` renvoie `PackageManager.PERMISSION_GRANTED` si la permission est accordée, sinon une autre valeur.
        val appPermission = ContextCompat.checkSelfPermission(this@Telephone, telPermission)

        // Déclare la constante qui représente le fait que la permission est accordée (valeur retournée par `checkSelfPermission`)
        val accordee = PackageManager.PERMISSION_GRANTED

        // Vérifie si la permission n'est pas encore accordée
        if (appPermission != accordee) {
            // Si la permission n'est pas accordée, on la demande à l'utilisateur via un dialogue de permission
            ActivityCompat.requestPermissions(this@Telephone, arrayOf(telPermission), 1)
        } else {
            // Si la permission est accordée, crée un `Intent` pour passer un appel téléphonique
            val intent = Intent(Intent.ACTION_CALL).apply {
                // Spécifie le numéro de téléphone à appeler en format URI (Universal Resource Identifier)
                data = Uri.parse("tel:$numero")
            }

            // Vérifie si une application capable de gérer l'intent (effectuer l'appel) est disponible sur l'appareil
            if (intent.resolveActivity(packageManager) != null) {
                // Si une telle application est trouvée, lance l'intent pour passer l'appel
                startActivity(intent)
            }
        }
    }

    // Sans verification (l'utilisateur ne doit pas donner son autorisation, l'appel doit etre confirmé avec le bouton d'appel
    //    fun telephoner() {
    //        // Créer un Intent pour ouvrir le dialer
    //        val dialIntent = Intent(Intent.ACTION_DIAL)
    //        dialIntent.data = Uri.parse("tel:$numeo")
    //        startActivity(dialIntent)
    //    }






}