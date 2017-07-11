package com.zxz.kotlin.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by zxz on 2017/7/6.
 */
data class BaseResult<T>(
        var reason: String,
        @SerializedName("error_code") var errorCode: Int,
        var result: T
)