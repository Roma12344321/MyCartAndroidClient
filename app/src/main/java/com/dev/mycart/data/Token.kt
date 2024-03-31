package com.dev.mycart.data

import com.google.gson.annotations.SerializedName

data class Token(
    @SerializedName("jwt_token")
    val token : String
)