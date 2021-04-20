package com.touta.courses.api.request

import com.touta.courses.R

class LoginRequest(val email : String , val password: String) {
    companion object{
        fun getErrors(loginRequest: LoginRequest): List<Int>{
            val errors  = ArrayList<Int>()
            if (loginRequest.email.isEmpty() || loginRequest.password.isEmpty())
                errors.add(R.string.fill_empty)
            return  errors
        }
    }
}