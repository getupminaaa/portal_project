package com.example.kcalculator

import com.example.kcalculator.network.ApiServer
import com.example.kcalculator.network.data.LoginRequest
import com.example.kcalculator.network.data.BaseResponse
import retrofit2.Callback

object UserDAO {
    fun login(email:String,password:String, callback: Callback<BaseResponse>) {
        ApiServer.network.login(email,password).enqueue(callback)
    }
    fun signup(email:String,password:String,name:String,age:Int,gender:Int,height:Float,weignt:Float,callback: Callback<BaseResponse>) {
        ApiServer.network.signup(email,password,name,age,gender,height,weignt).enqueue(callback)
    }
}