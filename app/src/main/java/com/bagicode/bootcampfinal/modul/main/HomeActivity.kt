package com.bagicode.bootcampfinal.modul.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bagicode.bootcampfinal.BootCamp
import com.bagicode.bootcampfinal.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var user = BootCamp.getApp().getUser()
    }
}