package com.touta.courses.api.response

data class BaseResponse<T> (val success : Boolean, val data : List<T>,val message : String ,val code : Int){

}