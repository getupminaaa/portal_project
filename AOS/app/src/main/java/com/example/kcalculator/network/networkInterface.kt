package com.example.kcalculator.network

import com.example.kcalculator.network.data.request.LoginRequest
import com.example.kcalculator.network.data.response.BaseResponse

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
interface networkInterface {

    @POST("v1/user/login")
    fun login(@Body loginRequest: LoginRequest):Call<BaseResponse>


    /**
     * 로그아웃
    //     *//*
        @GET("v1/user/logout")
        fun logout(): Call<BaseResponse>


        */
    /**
     * 회원가입
     *//*

        @POST("v1/user/add")
        fun add(@Body userRequest: UserRequest):Call<BaseResponse>
        */

}
