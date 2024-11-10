package com.example.interractivityapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Sms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        findViewById<EditText>(R.id.editTextNumeroSms).hint = "Numero de telephone"
        findViewById<EditText>(R.id.editTextSms).hint = "Message"

        findViewById<Button>(R.id.btnEnvoyerSms).setOnClickListener {
            checkSmsPermission()

        }
    }


    private val SMS_PERMISSION_CODE = 100 // arbitraire
    // si plusieurs permissions
    //    private val LOCATION_PERMISSION_CODE = 101
    //    private val CAMERA_PERMISSION_CODE = 102

    // Vérifier la permission d'envoi de SMS et demander si nécessaire
    private fun checkSmsPermission() {
        if (ContextCompat.checkSelfPermission(this@Sms, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this@Sms, arrayOf(Manifest.permission.SEND_SMS), SMS_PERMISSION_CODE)
        } else {
            sendSms()

        }
    }

    private fun sendSms() {

        val numero = findViewById<EditText>(R.id.editTextNumeroSms).text.toString()
        val message = findViewById<EditText>(R.id.editTextSms).text.toString()


        try { // tester parametre du sms
            val smsManager: SmsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(numero, null, message, null, null)
            Toast.makeText(this, "SMS envoyé!", Toast.LENGTH_SHORT).show()

            findViewById<TextView>(R.id.textViewNumeroEnvoye).text = numero
            findViewById<TextView>(R.id.textViewSmsEnvye).text = message
            findViewById<EditText>(R.id.editTextNumeroSms).text.clear()
            findViewById<EditText>(R.id.editTextSms).text.clear()

//            val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
//            val editor = sharedPreferences.edit()
//            editor.putString(numero, message)
//            editor.apply()

        } catch (e: Exception) {
            Toast.makeText(this, "Échec de l'envoi du SMS.", Toast.LENGTH_SHORT).show()
        }
    }

    // gerer les permissions
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == SMS_PERMISSION_CODE) {
            // si accoré envoyer SMS
            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                sendSms()
            } else {
                Toast.makeText(this, "Permission refusée pour l'envoi de SMS.", Toast.LENGTH_SHORT).show()
            }
        }
    }


    // Historique sms
    private fun histoSms() {


    }



}