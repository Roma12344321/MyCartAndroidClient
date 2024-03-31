package com.dev.mycart.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.dev.mycart.data.RepositoryImpl
import com.dev.mycart.domain.Repository
import com.dev.myposts.data.ApiFactory
import com.dev.myposts.data.ApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DataModule {

    @Singleton
    @Binds
    fun bindRepositoryImpl(impl: RepositoryImpl): Repository

    companion object {

        @Singleton
        @Provides
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }
        @Singleton
        @Provides
        fun provideSharedPreferences(application: Application): SharedPreferences {
            return application.getSharedPreferences(RepositoryImpl.PREFERENCES, Context.MODE_PRIVATE)
        }
    }
}