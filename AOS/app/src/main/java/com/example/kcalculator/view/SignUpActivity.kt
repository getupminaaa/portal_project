package com.example.kcalculator.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kcalculator.R
import com.example.kcalculator.UserDAO
import com.example.kcalculator.network.data.BaseResponse
import kotlinx.android.synthetic.main.activity_sign_up.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity:AppCompatActivity() {
    private var userDAO = UserDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var email:String =""
        var password:String=""
        var name:String=""
        var gender:Int=0
        var age:Int=0
        var height:Float=0.0F
        var weight:Float=0.0F

        update_finish_btn.setOnClickListener {
            email = sign_up_email_et.text.toString()
            password= update_pwd_et.text.toString()
            name =  update_name_et.text.toString()
            age= update_age_et.text.toString().toInt()
            gender = update_gender_et.text.toString().toInt()
            height = update_height_et.text.toString().toFloat()
            weight = update_weight_et.text.toString().toFloat()

            userDAO.signup(email,password,name,age,gender,height,weight,callback = object:Callback<BaseResponse>{
                override fun onResponse(
                    call: Call<BaseResponse>,
                    response: Response<BaseResponse>
                ) {
                    if(response.isSuccessful){
                        var result = response.body()!!
                        if(result.resultCode==0){
                            startActivity()
                        }
                    }
                }

                override fun onFailure(call: Call<BaseResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        }

    }
    private fun startActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}