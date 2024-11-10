package com.example.projetrecap.models

data class Utilisateur(
    val id: String,
    val nom: String,
    val prenom: String,
    val tel: String,
    val role: String,
    val mail: String,
    val password: String
)
