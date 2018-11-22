package com.example.sushmitanadgir.horizontalscrolling.ViewModel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.sushmitanadgir.horizontalscrolling.ApiManager.NetworkRepository
import com.example.sushmitanadgir.horizontalscrolling.Model.JsonResponse
import com.example.sushmitanadgir.horizontalscrolling.R

class MainViewModel(application: Application) : AndroidViewModel(application) {

    init {
        NetworkRepository.instance.fetchUsers()
    }

    fun getCategoryImages(categoryImageUrls:ArrayList<Int>,categoryNames:ArrayList<String>){
        categoryImageUrls.add(R.drawable.travell)
        categoryNames.add("Travel")

        categoryImageUrls.add(R.drawable.beauty)
        categoryNames.add("Beauty")

        categoryImageUrls.add(R.drawable.food)
        categoryNames.add("Food")

        categoryImageUrls.add(R.drawable.vintage)
        categoryNames.add("Vintage")

        categoryImageUrls.add(R.drawable.photography)
        categoryNames.add("Photography")
    }

    fun getPhotoImages(photoImageUrls:ArrayList<String>){
        photoImageUrls.add("https://images.pexels.com/photos/247929/pexels-photo-247929.jpeg?cs=srgb&dl=antiques-bicycle-bike-247929.jpg&fm=jpg")

        photoImageUrls.add("https://images.pexels.com/photos/92866/pexels-photo-92866.jpeg?cs=srgb&dl=cars-city-cityscape-92866.jpg&fm=jpg")

        photoImageUrls.add("https://images.pexels.com/photos/529926/pexels-photo-529926.jpeg?cs=srgb&dl=alphabets-ancient-box-529926.jpg&fm=jpg")

        photoImageUrls.add("https://images.pexels.com/photos/1070981/pexels-photo-1070981.jpeg?cs=srgb&dl=christmas-christmas-tree-christmas-wallpaper-1070981.jpg&fm=jpg")

        photoImageUrls.add("https://images.pexels.com/photos/712618/pexels-photo-712618.jpeg?cs=srgb&dl=asphalt-auto-automobile-712618.jpg&fm=jpg")

    }

    fun setUserData(): LiveData<JsonResponse> {
        return NetworkRepository.instance.getUserData()
    }

}
