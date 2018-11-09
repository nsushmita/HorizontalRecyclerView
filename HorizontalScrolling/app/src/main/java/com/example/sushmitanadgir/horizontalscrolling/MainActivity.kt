 package com.example.sushmitanadgir.horizontalscrolling

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.SnapHelper
import com.example.sushmitanadgir.horizontalscrolling.adapters.BookAdapter
import com.example.sushmitanadgir.horizontalscrolling.adapters.CategoriesAdapter
import com.example.sushmitanadgir.horizontalscrolling.adapters.PhotoAdapter
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

     private val snapHelper:SnapHelper = LinearSnapHelper()
     private val categoryNames : ArrayList<String> = ArrayList()
     private val bookNames: ArrayList<String> = ArrayList()
     private val categoryImageUrls: ArrayList<String> = ArrayList()
     private val photoImageUrls: ArrayList<String> = ArrayList()
     private val bookImageUrls: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //for photos
        getPhotoImages()
        photos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        photos.adapter = PhotoAdapter(this, photoImageUrls)

        snapHelper.attachToRecyclerView(photos)

        //for categories
        getCategoryImages()
        categories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        categories.adapter = CategoriesAdapter(this, categoryNames, categoryImageUrls)

        snapHelper.attachToRecyclerView(categories)

        //for books
        getBookImages()
        books.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        books.adapter =
                BookAdapter(this, bookNames, bookImageUrls)
    }

     private fun getCategoryImages(){
         categoryImageUrls.add("https://images.pexels.com/photos/297755/pexels-photo-297755.jpeg?cs=srgb&dl=adult-book-business-297755.jpg&fm=jpg")
         categoryNames.add("Travel")

         categoryImageUrls.add("https://images.pexels.com/photos/354962/pexels-photo-354962.jpeg?cs=srgb&dl=beauty-blush-brush-354962.jpg&fm=jpg")
         categoryNames.add("Beauty")

         categoryImageUrls.add("https://images.pexels.com/photos/76093/pexels-photo-76093.jpeg?cs=srgb&dl=cooking-dinner-food-76093.jpg&fm=jpg")
         categoryNames.add("Food")

         categoryImageUrls.add("https://images.pexels.com/photos/997405/pexels-photo-997405.jpeg?cs=srgb&dl=accessory-art-blur-997405.jpg&fm=jpg")
         categoryNames.add("Vintage")

         categoryImageUrls.add("https://images.pexels.com/photos/1264210/pexels-photo-1264210.jpeg?cs=srgb&dl=adult-beautiful-bush-1264210.jpg&fm=jpg")
         categoryNames.add("Photography")
     }

     private fun getPhotoImages(){
         photoImageUrls.add("https://images.pexels.com/photos/247929/pexels-photo-247929.jpeg?cs=srgb&dl=antiques-bicycle-bike-247929.jpg&fm=jpg")

         photoImageUrls.add("https://images.pexels.com/photos/92866/pexels-photo-92866.jpeg?cs=srgb&dl=cars-city-cityscape-92866.jpg&fm=jpg")

         photoImageUrls.add("https://images.pexels.com/photos/529926/pexels-photo-529926.jpeg?cs=srgb&dl=alphabets-ancient-box-529926.jpg&fm=jpg")

         photoImageUrls.add("https://images.pexels.com/photos/1070981/pexels-photo-1070981.jpeg?cs=srgb&dl=christmas-christmas-tree-christmas-wallpaper-1070981.jpg&fm=jpg")

         photoImageUrls.add("https://images.pexels.com/photos/712618/pexels-photo-712618.jpeg?cs=srgb&dl=asphalt-auto-automobile-712618.jpg&fm=jpg")

     }

     private fun getBookImages(){
         bookImageUrls.add("https://swoonproduction.s3.amazonaws.com/media/original_images/Bridge-Cover-198x300.jpg")
         bookNames.add("Classics")

         bookImageUrls.add("https://creativesessions.s3.amazonaws.com/content/2010/cs3_digital_illustration/article_children_book_covers/21-digital-illustrated-childrens-book-cover.jpg")
         bookNames.add("Rom Com")

         bookImageUrls.add("https://images-na.ssl-images-amazon.com/images/I/61q8Y%2BcNU9L._SX351_BO1,204,203,200_.jpg")
         bookNames.add("Children")

         bookImageUrls.add("https://i.pinimg.com/736x/eb/67/ba/eb67ba8da203f2a29545796a14d64a0e--victorian-books-illustration-children.jpg")
         bookNames.add("Knowledge")

         bookImageUrls.add("https://i.pinimg.com/originals/2f/6e/b9/2f6eb904980a4c6f54f2814052fdeac7.jpg")
         bookNames.add("History")
     }
 }
