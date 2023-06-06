package com.i9betstoryphat.i9bet.data

import com.google.gson.annotations.SerializedName

data class LoginPhone(
    val homeURL: String = "",
    val changeURL: String = "",
    val mobile: String = "",
    val contact: String = "",
    val lct: String = ""
)


data class LoginRequest(
    val phone: String,
    @SerializedName("package")
    val packageName: String,
    val simulator: String,
    val appName: String

)