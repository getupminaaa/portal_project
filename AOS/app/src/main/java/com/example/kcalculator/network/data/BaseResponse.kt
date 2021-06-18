package com.example.kcalculator.network.data

import com.example.kcalculator.network.ServerResult
import java.util.*

open class BaseResponse(
    var resultCode: Int = -2,
    var desc: String? = null,
    var body: Any? = null
) : ServerResult {

    override fun isSuccess(): Boolean {
        return resultCode == 0
    }

    override fun resultCode(): String {
        return resultCode.toString()
    }

    override fun errorMessage(): String? {
        return desc
    }
}