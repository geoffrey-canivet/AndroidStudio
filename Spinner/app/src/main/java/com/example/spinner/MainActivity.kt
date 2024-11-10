package com.example.spinner

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

// buid.gradle.kts (Module:app)
//        android {
//            namespace = "com.example.spinner"
//            compileSdk = 35
//
//            defaultConfig {
//                applicationId = "com.example.spinner"
//                minSdk = 21
//                targetSdk = 35
//                versionCode = 1
//                versionName = "1.0"
//
//                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//            }
        val mySpinner: Spinner = findViewById(R.id.spinner)
        val options = listOf("Option 1", "Option 2", "Option 3")
        val adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        mySpinner.adapter = adapter





        findViewById<Button>(R.id.button).setOnClickListener {
            val selectedOption = mySpinner.selectedItem.toString()
            // Vérifier si la CheckBox est cochée
            val checkBox = findViewById<CheckBox>(R.id.checkBox)
            val isChecked = checkBox.isChecked
            Log.d("MAIN", "chack: $isChecked spinner: $selectedOption")
        }


    }
}