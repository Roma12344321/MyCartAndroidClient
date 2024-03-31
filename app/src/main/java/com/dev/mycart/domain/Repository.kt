package com.dev.mycart.domain

interface Repository {
    suspend fun logIn(username: String, password: String) : Boolean
    suspend fun createPerson(person: Person) : Boolean
}