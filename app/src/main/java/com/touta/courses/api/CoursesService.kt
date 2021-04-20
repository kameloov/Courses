package com.touta.courses.api

import com.touta.courses.api.request.LoginRequest
import com.touta.courses.api.response.BaseResponse
import com.touta.courses.api.response.RegisterResponse
import com.touta.courses.api.request.RegistrationRequest
import com.touta.courses.model.User
import retrofit2.Response
import retrofit2.http.*

interface CoursesService {

    @Headers("Accept: application/json")
    @POST("users/register")
    suspend fun register(@Body registrationRequest: RegistrationRequest):Response<RegisterResponse>

    @Headers("Accept: application/json")
    @POST("users/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<BaseResponse<List<User>>>
}