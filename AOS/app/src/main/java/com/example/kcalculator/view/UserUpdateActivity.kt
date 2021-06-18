package com.example.kcalculator.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kcalculator.R
import com.example.kcalculator.UserDAO
import com.example.kcalculator.network.data.BaseResponse
import kotlinx.android.synthetic.main.activity_user_update.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserUpdateActivity : AppCompatActivity() {
    var userDAO = UserDAO
    var userInfo = UserInfo()
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update)

        get_user_btn.setOnClickListener {
            userDAO.getInfo(
                token = LoginActivity.token,
                callback = object : Callback<BaseResponse> {
                    override fun onResponse(
                        call: Call<BaseResponse>,
                        response: Response<BaseResponse>
                    ) {
                        if (response.isSuccessful) {
                            val result = response.body()!!
                            if (result.resultCode == 0) {
                                Log.d("TAG", "onResponse: ${result.body}")
                            }

                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    }
                })
        }
    }
}

data class UserInfo(
    var name: String = "",
    var age: Int = 0,
    var gender: Int = 0,
    var height: Float = 0.0F,
    var weight: Float = 0.0F
)