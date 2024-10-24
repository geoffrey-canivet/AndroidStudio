package com.example.loginutilisateur

import android.app.Application


class Gestion : Application() {

    var toastMessage: String? = null

    override fun onCreate() {
        super.onCreate()
        toastMessage = "Bienvenue"
    }




}