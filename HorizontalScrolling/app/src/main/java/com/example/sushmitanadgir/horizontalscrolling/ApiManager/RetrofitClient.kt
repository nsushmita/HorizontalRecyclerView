package com.example.sushmitanadgir.horizontalscrolling.ApiManager

import com.example.sushmitanadgir.retrofit.ApiManager.ApiUsers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        private var mPostApiInterface: ApiUsers ? = null
        private var mRetrofit: Retrofit? = null
        fun mClient():Retrofit?
        {
            if(mRetrofit==null)
            {
                synchronized(RetrofitClient::class.java)
                {
                    if(mRetrofit==null)
                    {
                        mRetrofit=Retrofit.Builder()
                            .baseUrl("https://reqres.in/api/")
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                    }
                }
            }
            return mRetrofit
        }
        fun service():ApiUsers?
        {
            if(mPostApiInterface==null)
            {
                synchronized(ApiUsers::class.java)
                {
                    if(mPostApiInterface==null)
                    {
                        mPostApiInterface= mClient()?.create(ApiUsers::class.java)
                    }
                }
            }
            return mPostApiInterface
        }
    }
}