package com.touta.courses.api.response

data class RegisterResponse(
    val success : Int, val data : Int?,
    val message: String?, val code: Int?
    )
