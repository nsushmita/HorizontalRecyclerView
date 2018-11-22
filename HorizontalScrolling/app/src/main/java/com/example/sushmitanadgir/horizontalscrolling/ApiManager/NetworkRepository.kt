package com.example.sushmitanadgir.horizontalscrolling.ApiManager

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.sushmitanadgir.horizontalscrolling.Model.JsonResponse
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


class NetworkRepository {

    private val mUserData = MutableLiveData<JsonResponse>()

    companion object {
        private var mNetworkClass: NetworkRepository? = null
        val instance: NetworkRepository
            @Synchronized get() {
                if (mNetworkClass == null) {
                    mNetworkClass = NetworkRepository()
                }
                return mNetworkClass as NetworkRepository
            }
    }


     fun fetchUsers() {

         RetrofitClient.service()?.getUsers()?.subscribeOn(Schedulers.newThread())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Subscriber<JsonResponse>(){
                override fun onNext(t: JsonResponse?) {
                    mUserData.value=t
                }

                override fun onCompleted() {}

                override fun onError(e: Throwable?) {
                    Log.d("Test",""+e)
                }
            })
     }

    fun getUserData() : LiveData<JsonResponse> {
         return mUserData
    }
}


