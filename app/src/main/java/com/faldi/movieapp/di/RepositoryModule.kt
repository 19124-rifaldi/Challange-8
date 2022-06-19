package com.faldi.movieapp.di

import com.faldi.movieapp.data.local.UserDao
import com.faldi.movieapp.repository.AuthRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideauth(userDao: UserDao):AuthRepo{
        return AuthRepo(userDao)
    }
}