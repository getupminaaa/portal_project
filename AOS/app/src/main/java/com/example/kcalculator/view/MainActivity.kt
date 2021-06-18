package com.example.kcalculator.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kcalculator.R
import com.example.kcalculator.UserDAO
import com.example.kcalculator.network.data.BaseResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val userDAO = UserDAO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user_update_btn.setOnClickListener {
            val intent = Intent(this, UserUpdateActivity::class.java)
            startActivity(intent)
        }
        user_delete_btn.setOnClickListener {
            userDAO.deleteInfo(LoginActivity.token, callback = object : Callback<BaseResponse> {
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    if (response.isSuccessful) {
                        startActivity()
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    Log.d("TAG", "onFailure:asdasd")
                }
            })
        }
    }

    fun startActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}