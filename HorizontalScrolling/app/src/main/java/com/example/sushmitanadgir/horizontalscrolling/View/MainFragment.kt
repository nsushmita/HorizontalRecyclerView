package com.example.sushmitanadgir.horizontalscrolling.View

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearSnapHelper
import android.support.v7.widget.SnapHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sushmitanadgir.horizontalscrolling.R
import com.example.sushmitanadgir.horizontalscrolling.ViewModel.MainViewModel
import com.example.sushmitanadgir.horizontalscrolling.adapters.CategoriesAdapter
import com.example.sushmitanadgir.horizontalscrolling.adapters.PhotoAdapter
import com.example.sushmitanadgir.horizontalscrolling.adapters.UserAdapter
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    private val snapHelper: SnapHelper = LinearSnapHelper()
    private val categoryNames : ArrayList<String> = ArrayList()
    private val categoryImageUrls: ArrayList<Int> = ArrayList()
    private val photoImageUrls: ArrayList<String> = ArrayList()

    private lateinit var viewModel: MainViewModel
    private lateinit var userAdapter: UserAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //for photos
        viewModel.getPhotoImages(photoImageUrls)
        photos.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
            context?.let {
                photos.adapter = PhotoAdapter(it, photoImageUrls)

            }
        snapHelper.attachToRecyclerView(photos)

        //for categories
        viewModel.getCategoryImages(categoryImageUrls,categoryNames)
        categories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)

            context?.let {
                categories.adapter = CategoriesAdapter(it, categoryNames, categoryImageUrls)
            }
        snapHelper.attachToRecyclerView(categories)

        //for books
        books.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        userAdapter = UserAdapter()
        books.adapter=userAdapter

        //observer
        viewModel.setUserData().observe(this,Observer{
            it?.let{
                userAdapter.setUsers(it.data)
                userAdapter.notifyDataSetChanged()
            }
        })
    }
}



