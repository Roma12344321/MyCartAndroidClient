package com.dev.mycart.domain

import javax.inject.Inject

class LogInUseCase @Inject constructor(
    private val repository: Repository
){
    suspend fun logIn(username: String, password: String) : Boolean {
        return repository.logIn(username, password)
    }
}