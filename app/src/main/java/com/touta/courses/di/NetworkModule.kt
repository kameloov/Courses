package com.touta.courses.di

import com.touta.courses.Utils
import com.touta.courses.api.CoursesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideService(): CoursesService{
        return  Retrofit.Builder().baseUrl(Utils.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(CoursesService::class.java)
    }
}