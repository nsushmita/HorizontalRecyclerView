package com.example.sushmitanadgir.horizontalscrolling.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sushmitanadgir.horizontalscrolling.R
import kotlinx.android.synthetic.main.row_categories.view.*
import java.util.*

class BookAdapter(private val mContext: Context, names: ArrayList<String>, imageUrls: ArrayList<String>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    private var mNames = ArrayList<String>()
    private var mImageUrls = ArrayList<String>()

    init {
        mNames= names
        mImageUrls = imageUrls
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.row_books,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(mContext)
            .asBitmap()
            .load(mImageUrls[position])
            .into(holder.image)

        holder.name.text = mNames[position]

        holder.image.setOnClickListener {
            Toast.makeText(mContext, mNames[position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return mImageUrls.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById(R.id.image_view) as ImageView
        val name: TextView = itemView.name
    }
}