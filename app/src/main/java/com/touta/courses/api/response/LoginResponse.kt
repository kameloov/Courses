package com.touta.courses.api.response

import com.touta.courses.api.Resource
import com.touta.courses.model.User

data class LoginResponse(val success: Int?, val data : List<User>?)
