package com.dev.mycart.data

import com.google.gson.annotations.SerializedName

data class AuthenticationDto(
    @SerializedName("username")
    val username : String,
    @SerializedName("password")
    val password : String
)