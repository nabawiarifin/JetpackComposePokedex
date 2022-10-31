package com.plcoding.jetpackcomposepokedex.util

// T in order to be able to wrap any object we like
sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)//Not null because if it's successfull then we get data
    class Error<T>(data: T? = null, message: String) : Resource<T>(data, message)
    class Loading<T>(data: T? = null) : Resource<T>(data)

}