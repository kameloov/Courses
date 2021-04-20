package com.touta.courses.api

sealed class Resource{
    data class Success<T>(val data :T):Resource()
    data class Error<T>(val code : T) :Resource()
    class Loading : Resource()
}
