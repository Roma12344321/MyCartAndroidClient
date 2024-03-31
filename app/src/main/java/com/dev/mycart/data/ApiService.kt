package com.dev.myposts.data

import com.dev.mycart.data.AuthenticationDto
import com.dev.mycart.data.PersonDto
import com.dev.mycart.data.Token
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("api/auth/login")
    suspend fun logIn(
        @Body authenticationDto : AuthenticationDto
    ) : Token
    @POST("api/auth/registration")
    suspend fun createPerson(
        @Body personDto: PersonDto
    ) : Token
}