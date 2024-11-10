package com.example.gestioncontacts

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val context: Context, private val contacts: List<Contact>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    // Elements a retrouver dans la card
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameView : TextView = itemView.findViewById(R.id.textViewNom)
        val telView : TextView = itemView.findViewById(R.id.textViewTel)
        val btnSupprimer: ImageView = itemView.findViewById(R.id.btnSupprimer)
        val btnInfo: ImageView = itemView.findViewById(R.id.imageViewInfo)

    }
    // Cree la nouvelle vue pour chaque elements // mise ne page
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_contact, parent, false)
        return ViewHolder(view)
    }
    // initialiser les elements
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.nameView.text = contact.nom
        holder.telView.text = contact.tel

        // Info contact
        holder.btnInfo.setOnClickListener {
            val intent = Intent(context, Info::class.java)
            val id = contact.id
            intent.putExtra("id", id)  // Utilisez putExtra pour ajouter "id" avec sa valeur
            context.startActivity(intent)  // Démarrez l'activité
        }

        // Supprimer contact
        holder.btnSupprimer.setOnClickListener {
            val utilisateurASupprimer = contact.id
            // Récupérer les SharedPreferences
            val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
            // Récupérer toutes les entrées
            val fichierPrefs: Map<String, *> = sharedPreferences.all
            // Supprimer l'entrée voulue
            val editor = sharedPreferences.edit()
            editor.remove(utilisateurASupprimer.toString())
            editor.apply()
            // Recharger Main
            context.startActivity(Intent(context, MainActivity::class.java))
        }

    }
    override fun getItemCount() = contacts.size
}
