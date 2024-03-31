package com.dev.mycart.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dev.mycart.domain.LogInUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class LogInViewModel @Inject constructor(
    private val logInUseCase: LogInUseCase
) : ViewModel() {

    private val scope = CoroutineScope(Dispatchers.Main)

    private val _isLoggedIn = MutableLiveData<Boolean>()
    val loggedIn : LiveData<Boolean>
        get() = _isLoggedIn

    fun logIn(username: String, password: String) {
        scope.launch {
            try {
                _isLoggedIn.value = logInUseCase.logIn(username, password)
            } catch (e: Exception) {
                _isLoggedIn.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}