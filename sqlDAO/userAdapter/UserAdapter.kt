package com.example.sqldemo.userAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sqldemo.MainActivity
import com.example.sqldemo.R
import com.example.sqldemo.models.User
import com.example.sqldemo.viewHolder.UserViewHolder

class UserAdapter (val users : List<User>) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
        /**
         * le viewHolder est là pour gérer les éléments de la liste. itemView c'est un peu comme la boîte qui contient les éléments.
         * Dans notre cas itemView contient le nom et le prénom de la personne concaténés dans un seul élément et son numéro de registre nationnal
         * Ici dans le code itemView permet de manipuler l'élement de la liste  et en y ajoutant un setOnClickListener on spécifie que quand quelqu'un
         * va cliquer sur un élément de la liste on récupère ses infos pour les afficher dans les champs de l'activité principale.
         * ***** val activity = holder.itemView.context as MainActivity *****
         * on vient récupérer le contexte de l'itemView. Ce contexte représente l'environement dans lequel l'itemView est affiché.
         * as MainActivity permet de caster le contexte en MainActivity pour dire au compilateur "hey mon ami, je sais que le contexte est vraiment un MainActivity
         * du coup on peut lui passer les infos de l'activité principale"
         *
         * **/
        holder.itemView.setOnClickListener {
            holder.itemView.setOnClickListener {
                val activity = holder.itemView.context as MainActivity
                activity.selectedUser = user
                activity.etFirstname.setText(user.firstName)
                activity.etLastname.setText(user.lastName)
                activity.etRegNat.setText(user.regNat)
            }
        }

    }
}