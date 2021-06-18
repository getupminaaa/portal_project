package com.example.kcalculator.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.kcalculator.R
import com.example.kcalculator.UserDAO
import com.example.kcalculator.network.data.BaseResponse
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    private var userDAO = UserDAO

    companion object {
        var token:String =""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var input_user_email: String = ""
        var input_user_pwd: String = ""
        login_sign_up_btn.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        login_finish_btn.setOnClickListener {
            input_user_email = login_email_et.text.toString()
            input_user_pwd = login_pwd_et.text.toString()
            userDAO.login(
                email = input_user_email, password = input_user_pwd,
                callback = object : Callback<BaseResponse> {
                    override fun onResponse(
                        call: Call<BaseResponse>,
                        response: Response<BaseResponse>
                    ) {
                        if (response.isSuccessful) {
                            var result = response.body()!!
                            if (result.resultCode == 0) {
                                token = result.body.toString()
                                Log.d("TAG", "onResponse: $token")
                                startActivity()

                            }
                        }
                    }

                    override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    }
                })
        }

    }

    private fun startActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}