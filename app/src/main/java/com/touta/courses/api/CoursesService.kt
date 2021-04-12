package com.touta.courses.api

import com.touta.courses.api.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.POST

interface CoursesService {

    @POST("users/register")
    suspend fun register(
        @Field("email")
        email :String ,
        @Field("password")
        password : String,
        @Field("name")
        name : String,
        @Field("phone")
        phone : String,
        @Field("fcm_key")
        fcm_token : String
    ):Response<RegisterResponse>
}