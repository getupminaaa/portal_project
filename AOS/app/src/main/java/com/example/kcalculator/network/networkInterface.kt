package com.example.kcalculator.network

import com.example.kcalculator.network.data.LoginRequest
import com.example.kcalculator.network.data.BaseResponse
import retrofit2.Call
import retrofit2.http.*

interface networkInterface {
    /*User*/
    @POST("user/signup")
    fun signup(
        @Query("email") email: String,
        @Query("password") password: String,
        @Query("name") name: String,
        @Query("age") age: Int,
        @Query("gender") gender: Int,
        @Query("weight") height: Float,
        @Query("height") weight: Float
    ): Call<BaseResponse>

    @POST("user/login")
    fun login(
        @Query("email") email: String,
        @Query("password") password: String
    ): Call<BaseResponse>

    @POST("user/update")
    fun update(
        @Query("token") token: String,
        @Query("name") name: String,
        @Query("age") age: Int,
        @Query("gender") gender: Int,
        @Query("height") height: Float,
        @Query("weight") weight: Float
    ): Call<BaseResponse>

    @GET("user/getInfo")
    fun getUserInfo(@Query("token")token: String):Call<BaseResponse>

    @DELETE("user/delete")
    fun deleteUser(@Query("token")token:String):Call<BaseResponse>

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