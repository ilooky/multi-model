package com.welooky.library

data class Response<T>(
    val data: T,
    val code: Int = 200,
    val message: String = "OK"
)
