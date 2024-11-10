package com.example.sqldemo.viewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sqldemo.R
import com.example.sqldemo.models.User

class UserViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val tvName : TextView = itemView.findViewById(R.id.tv_name)
    val tvRegNat : TextView = itemView.findViewById(R.id.tv_reg_nat)

    fun bind(user : User) {
        tvName.text = "${user.firstName} ${user.lastName}"
        tvRegNat.text = user.regNat
    }

}