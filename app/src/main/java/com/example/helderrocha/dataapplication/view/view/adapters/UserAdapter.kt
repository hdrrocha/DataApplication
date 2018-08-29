package com.example.helderrocha.dataapplication.view.view.adapters

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helderrocha.dataapplication.R
import com.example.helderrocha.dataapplication.view.model.User
import kotlinx.android.synthetic.main.user_item.view.*
import java.util.*

class UserAdapter(var userData: List<User>?, val clickListener: (User) -> Unit) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var imageUsr: Int = 0
        fun bind(user: User, clickListener: (User) -> Unit) {
            itemView.textName.text = "Nome: " + user.name
            itemView.textSenha.text = "Senha: " +user.pwd
            itemView.textId.text = "id: "+ user.id
            itemView.imageUser.setImageResource(getImage())
            itemView.setOnClickListener { clickListener(user)}
        }

        private fun getImage(): Int {

            var number = Random().nextInt(7) +1
            when (number) {
                1 -> imageUsr = R.drawable.g1
                2 -> imageUsr = R.drawable.g2
                3 -> imageUsr = R.drawable.g3
                4 -> imageUsr = R.drawable.g4
                5 -> imageUsr = R.drawable.g5
                6 -> imageUsr = R.drawable.g6
                7 -> imageUsr = R.drawable.g7
                else -> {
                    Log.i("ERROR", "Sem imagem")
                }
            }
            return imageUsr
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userData!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        (holder as ViewHolder).bind(userData!![position], clickListener)
    }

}
