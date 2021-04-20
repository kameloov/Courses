package com.touta.courses.repository

import com.touta.courses.api.CoursesService
import com.touta.courses.api.request.LoginRequest
import com.touta.courses.api.response.BaseResponse
import com.touta.courses.api.response.RegisterResponse
import com.touta.courses.api.request.RegistrationRequest
import com.touta.courses.model.User

class UserRepositoryImpl(private val service: CoursesService) : UserRepository  {


    override suspend fun register(registrationRequest: RegistrationRequest): RegisterResponse? {
        return service.register(registrationRequest).body()
    }

    override suspend fun login(loginRequest: LoginRequest): BaseResponse<List<User>>? {
        return service.login(loginRequest).body()
    }
}