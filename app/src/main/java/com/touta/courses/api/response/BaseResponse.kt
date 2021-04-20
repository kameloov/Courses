package com.touta.courses.api.response

data class BaseResponse<out T> (val success : Int, val data : T?,val message : String? ,val code : Int?){

}