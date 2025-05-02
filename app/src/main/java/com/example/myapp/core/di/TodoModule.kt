package com.example.myapp.core.di

import android.content.Context
import com.example.myapp.data.local.AppDatabase
import com.example.myapp.data.local.dao.TodoDao
import com.example.myapp.data.remote.api.RemoteTodoApi
import com.example.myapp.data.repository.RemoteTodoRepositoryImpl
import com.example.myapp.data.repository.TodoRepositoryImpl
import com.example.myapp.domain.repository.RemoteTodoRepository
import com.example.myapp.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TodoModule {

    @Provides
    @Singleton
    fun provideTodoRepository(
        dao: TodoDao
    ): TodoRepository = TodoRepositoryImpl(dao)

    @Provides
    @Singleton
    fun provideTodoDao(db: AppDatabase): TodoDao = db.todoDao()

    @Provides
    fun provideRemoteTodoApi(retrofit: Retrofit): RemoteTodoApi =
        retrofit.create(RemoteTodoApi::class.java)

    @Provides
    fun provideRemoteTodoRepository(api: RemoteTodoApi): RemoteTodoRepository =
        RemoteTodoRepositoryImpl(api)

}