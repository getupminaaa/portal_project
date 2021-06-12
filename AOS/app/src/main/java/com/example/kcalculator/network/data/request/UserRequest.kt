package com.example.kcalculator.network.data.request

data class UserRequest (
    val user_name:String,
    val user_email:String,
    val user_pwd:String,
    val user_gender:Int,
    val user_age:Int,
    val user_weight:Float,
    val user_height:Float
)
