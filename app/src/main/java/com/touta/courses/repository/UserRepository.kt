package com.touta.courses.repository

import com.touta.courses.api.request.LoginRequest
import com.touta.courses.api.response.BaseResponse
import com.touta.courses.api.response.RegisterResponse
import com.touta.courses.api.request.RegistrationRequest
import com.touta.courses.model.User

interface UserRepository {
    suspend fun register(registrationRequest : RegistrationRequest):RegisterResponse?
    suspend fun login(loginRequest: LoginRequest) : BaseResponse<List<User>>?
}