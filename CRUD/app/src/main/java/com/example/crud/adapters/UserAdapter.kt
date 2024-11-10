package com.example.crud.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud.R
import com.example.crud.models.User


class UserAdapter(private val dataList: MutableList<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUser : TextView = itemView.findViewById(R.id.textViewNom)
        val textViewPrenom : TextView = itemView.findViewById(R.id.textViewPrenom)
        val textViewRC : TextView = itemView.findViewById(R.id.textViewRC)
        val textViewId : TextView = itemView.findViewById(R.id.textViewId)

    }

    // Crée une nouvelle vue qui sera affichée dans le RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_user, parent, false)
        return ViewHolder(view)
    }

    // Remplit la vue avec les données du User à la position donnée
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = dataList[position]
        holder.textViewUser.text = user.lastname
        holder.textViewPrenom.text = user.firstname
        holder.textViewRC.text = user.regNat
        holder.textViewId.text = user.id.toString()
    }

    // Renvoie le nombre total d'éléments dans la liste
    override fun getItemCount(): Int {
        return dataList.size
    }

}