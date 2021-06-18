package com.example.kcalculator.view

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kcalculator.R

class UserUpdateActivity : AppCompatActivity(){
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update)

    }
}