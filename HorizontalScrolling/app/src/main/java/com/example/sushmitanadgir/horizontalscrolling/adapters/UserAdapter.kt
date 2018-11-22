package com.example.sushmitanadgir.horizontalscrolling.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.sushmitanadgir.horizontalscrolling.Model.Datum
import com.example.sushmitanadgir.horizontalscrolling.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_books.view.*


class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private var users = ArrayList<Datum>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_books, parent, false)
        return UserAdapter.UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.firstName.text = users[position].first_name
        Picasso.get().load(users[position].avatar).into(holder.avatarImage)
    }

    fun setUsers(data: ArrayList<Datum>) {
        users.addAll(data)
        notifyDataSetChanged()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstName : TextView = itemView.name_books
        val avatarImage: ImageView = itemView.image_view_books
    }
}