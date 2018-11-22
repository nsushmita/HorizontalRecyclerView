package com.example.sushmitanadgir.horizontalscrolling.adapters


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.sushmitanadgir.horizontalscrolling.R
import java.util.ArrayList
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.row_categories.view.*


class CategoriesAdapter(private val mContext: Context, names: ArrayList<String>, imageUrls: ArrayList<Int>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var mNames = ArrayList<String>()
    private var mImageUrls = ArrayList<Int>()

    init {
        mNames = names
        mImageUrls = imageUrls
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_categories, parent, false)
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

     class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val image: CircleImageView =itemView.image_view
         val name: TextView = itemView.name
     }
}
