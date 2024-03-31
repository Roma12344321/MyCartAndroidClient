package com.dev.mycart.di

import androidx.lifecycle.ViewModel
import com.dev.mycart.presentation.LogInViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(LogInViewModel::class)
    fun bindLogInViewModel(viewModel: LogInViewModel): ViewModel
}