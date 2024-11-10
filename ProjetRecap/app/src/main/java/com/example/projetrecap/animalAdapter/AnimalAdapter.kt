package com.example.projetrecap.animalAdapter

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projetrecap.R
import com.example.projetrecap.activities.Dashboard
import com.example.projetrecap.activities.FicheAnimal
import com.example.projetrecap.models.Animal

class AnimalAdapter (private val context: Context, private val animaux: List<Animal>) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>(){

    // ViewHolder / Recup items
    inner class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val typeTextView: TextView = itemView.findViewById(R.id.cardAnimType)
        val nomTextView: TextView = itemView.findViewById(R.id.cardAnimNom)
        val isfed: TextView = itemView.findViewById(R.id.cardAnimIsFed)
        val btnSupprimer: ImageView = itemView.findViewById(R.id.icoSupprimer)
        val btnInfo: ImageView = itemView.findViewById(R.id.imageView)
        val imgType: ImageView = itemView.findViewById(R.id.avatType)
        val btnTel: ImageView = itemView.findViewById(R.id.icoTel)
    }

    // Création d'un item / Ajoute au xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_animal, parent, false)
        return AnimalViewHolder(view)
    }

    // Gestion des items
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = animaux[position]

        // card
        holder.typeTextView.text = animal.type
        holder.nomTextView.text = animal.nom
        holder.isfed.text = animal.isFed.toString()
        when (animal.type) {
            "Lion" -> holder.imgType.setImageResource(R.drawable.lion)
            "Crocodile" -> holder.imgType.setImageResource(R.drawable.crocodile)
            "Cheval" -> holder.imgType.setImageResource(R.drawable.cheval)
            "Koala" -> holder.imgType.setImageResource(R.drawable.koala)
            "Lapin" -> holder.imgType.setImageResource(R.drawable.lapin)
            "Tigre" -> holder.imgType.setImageResource(R.drawable.tigre)
            "Phacochere" -> holder.imgType.setImageResource(R.drawable.phacochere)
            "rene" -> holder.imgType.setImageResource(R.drawable.rene)
            "pingouin" -> holder.imgType.setImageResource(R.drawable.pinguin)
            else -> holder.imgType.setImageResource(R.drawable.cheval)
        }

        // Supprimer avec id
        holder.btnSupprimer.setOnClickListener {
            val idAnimal = animal.id
            val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.remove(idAnimal.toString())
            editor.apply()
            context.startActivity(Intent(context, Dashboard::class.java))
        }

        // intent ctivity ficheAnimal
        holder.btnInfo.setOnClickListener {
            // passer id de l'animal a activity fiche
            val intent = Intent(context, FicheAnimal::class.java)
            intent.putExtra("id", animal.id.toString())
            intent.putExtra("type", animal.type)
            intent.putExtra("nom", animal.nom)
            intent.putExtra("age", animal.age.toString())
            intent.putExtra("sexe", animal.sexe)
            intent.putExtra("isFed", animal.isFed.toString())
            context.startActivity(intent)
        }

        // telephone
        holder.btnTel.setOnClickListener {
            val numero = "0478 00 11 22"
            val telPermission = android.Manifest.permission.CALL_PHONE
            if (ContextCompat.checkSelfPermission(context, telPermission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this.context as Dashboard, arrayOf(telPermission), 1)
            } else {
                val intent = Intent(Intent.ACTION_CALL).apply {
                    data = Uri.parse("tel:$numero")
                }
                context.startActivity(intent)
            }
        }






    }

    override fun getItemCount() = animaux.size
}