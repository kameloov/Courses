package com.touta.courses.di

import com.touta.courses.api.CoursesService
import com.touta.courses.repository.UserRepository
import com.touta.courses.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUSerRepository(service: CoursesService):UserRepository = UserRepositoryImpl(service)

}