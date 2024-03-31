package com.dev.mycart.data

import android.app.Application
import android.content.SharedPreferences
import com.dev.mycart.domain.Person
import com.dev.mycart.domain.Repository
import com.dev.myposts.data.ApiService
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val application: Application,
    private val apiService: ApiService,
    private val sharedPreferences: SharedPreferences,
    private val mapper: LogInMapper
): Repository {

    override suspend fun logIn(username: String, password: String): Boolean {
        val token = apiService.logIn(AuthenticationDto(username,password)).token
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN_KEY,token)
        editor.apply()
        return true
    }
    override suspend fun createPerson(person: Person): Boolean {
        val token = apiService.createPerson(mapper.mapPersonToPersonDto(person)).token
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN_KEY,token)
        editor.apply()
        return true
    }
    companion object {
        const val PREFERENCES = "default_prefs"
        const val TOKEN_KEY = "key"
    }
}