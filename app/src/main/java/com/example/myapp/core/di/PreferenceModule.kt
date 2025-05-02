package com.example.myapp.core.di

import android.content.Context
import android.content.SharedPreferences
import com.example.myapp.core.SharedPrefsManager
import com.fasterxml.jackson.databind.ObjectMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Provides
    @Singleton
    fun provideSharedPrefsManager(
        @ApplicationContext context: Context
    ): SharedPrefsManager = SharedPrefsManager(context)
}