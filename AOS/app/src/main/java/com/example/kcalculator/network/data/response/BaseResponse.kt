package com.example.kcalculator.network.data.response

import com.example.kcalculator.network.ServerResult

open class BaseResponse(
    var resultCode: Int = -1,
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
