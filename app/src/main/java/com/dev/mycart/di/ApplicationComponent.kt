package com.dev.mycart.di

import android.app.Application
import com.dev.mycart.presentation.LogInFragment
import com.dev.mycart.presentation.MainFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class,ViewModelModule::class])
interface ApplicationComponent {
    fun inject(fragment: LogInFragment)
    fun inject(fragment: MainFragment)


    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}