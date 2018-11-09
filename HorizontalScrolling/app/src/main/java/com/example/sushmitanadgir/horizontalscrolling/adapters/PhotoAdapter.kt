package com.example.sushmitanadgir.horizontalscrolling.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.sushmitanadgir.horizontalscrolling.R
import java.util.*

class PhotoAdapter(private val mContext: Context,  imageUrls: ArrayList<String>) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private var mImageUrls = ArrayList<String>()

    init {
        mImageUrls = imageUrls
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_photos, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(mContext)
            .asBitmap()
            .load(mImageUrls[position])
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return mImageUrls.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var image = itemView.findViewById(R.id.image_view) as ImageView
    }
}