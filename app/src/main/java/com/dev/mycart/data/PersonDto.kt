package com.dev.mycart.data

import com.google.gson.annotations.SerializedName


data class PersonDto(
    @SerializedName("username")
    val username: String?,
    @SerializedName("password")
    val password: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("year")
    val year: Int?,
    @SerializedName("avatar")
    val avatar : String?
)