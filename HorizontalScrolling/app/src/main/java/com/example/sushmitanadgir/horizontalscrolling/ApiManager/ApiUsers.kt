package com.example.sushmitanadgir.retrofit.ApiManager

import com.example.sushmitanadgir.horizontalscrolling.Model.JsonResponse

import retrofit2.http.GET
import rx.Observable


interface ApiUsers {
    @GET("users?page=1")
    fun getUsers(): Observable<JsonResponse>
}