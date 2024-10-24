package com.example.listes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val dataList: List<String>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    // La classe CustomAdapter prend une liste de chaînes de caractères (dataList).
    // Elle étend la classe RecyclerView.Adapter, en utilisant un ViewHolder personnalisé.

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // ViewHolder représente chaque élément individuel dans le RecyclerView.
        // itemView représente l'élément dans la vue.

        val textView : TextView = itemView.findViewById(R.id.textView1)
        // textView est un TextView trouvé dans le layout (par exemple, 'card_view.xml').
        // Il est utilisé pour afficher les données.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Méthode appelée lors de la création d'un nouvel élément de vue.
        // Elle gonfle le layout (XML) pour chaque élément de la liste.

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        // Inflate le layout 'card_view' pour créer la vue de l'élément (le parent est le RecyclerView).
        // false signifie que nous n'ajoutons pas encore cette vue à son parent.

        return ViewHolder(view)
        // Retourne une instance de ViewHolder contenant la vue gonflée.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Méthode appelée pour lier les données à la vue pour chaque élément (lors du défilement).

        holder.textView.text = dataList[position]
        // Assigne la valeur de l'élément de la liste (dataList[position]) au TextView du ViewHolder.
    }

    override fun getItemCount() = dataList.size
    // Retourne la taille de la liste (le nombre d'éléments dans dataList), utilisée par le RecyclerView.
}
