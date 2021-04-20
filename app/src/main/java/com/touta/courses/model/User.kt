package com.touta.courses.model

data class User(
    val balance: Float,
    val email: String,
    val fcm_key: String,
    val id: String,
    val logged: Boolean,
    val name: String,
    val password: String,
    val phone: String,
    val videos: String
)