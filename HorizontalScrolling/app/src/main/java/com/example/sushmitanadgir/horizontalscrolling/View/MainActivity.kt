 package com.example.sushmitanadgir.horizontalscrolling.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.sushmitanadgir.horizontalscrolling.R

 class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         val transaction = supportFragmentManager.beginTransaction()
         val fragment = MainFragment()
         transaction.replace(R.id.fragment_holder, fragment)
         transaction.addToBackStack(null)
         transaction.commit()
     }
 }
