package com.example.kcalculator.network

import com.example.kcalculator.network.data.LoginRequest
import com.example.kcalculator.network.data.BaseResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface networkInterface {
    /*User*/
    @POST("user/signup")
    fun signup(@Query("email")email:String,
               @Query("password")password:String,
               @Query("name")name:String,
               @Query("age")age:Int,
               @Query("gender")gender:Int,
               @Query("weight")height:Float,
               @Query("height")weight:Float
    ):Call<BaseResponse>

    @POST("user/login")
    fun login(@Query("email")email:String, @Query("password")password:String):Call<BaseResponse>

    //R

    //U
    //D
    /*Record*/
    //C
    //R
    //U
    //D
    /*Food*/
    //C
    //R
    //U
    //D
}