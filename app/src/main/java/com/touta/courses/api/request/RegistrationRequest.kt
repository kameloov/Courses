package com.touta.courses.api.request

import com.touta.courses.R

class RegistrationRequest(
    val email: String, val password: String, val confirmPassword:String,
    val name: String, val phone: String, val fcm_key: String
    ){
    companion object{
        public fun getErrors(info : RegistrationRequest): List<Int>{
            val errors = ArrayList<Int>()
            with(info){
                if (email.isEmpty() || password.isEmpty()|| name.isEmpty())
                    errors.add(R.string.fill_empty)
                if (!password.equals(confirmPassword))
                    errors.add(R.string.confirm_not_match)
                if (password.length<6)
                    errors.add(R.string.password_short)
            }
            return  errors
        }
    }
}
