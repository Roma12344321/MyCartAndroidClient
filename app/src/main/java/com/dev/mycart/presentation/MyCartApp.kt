package com.dev.mycart.presentation

import android.app.Application
import com.dev.mycart.di.DaggerApplicationComponent

class MyCartApp : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}