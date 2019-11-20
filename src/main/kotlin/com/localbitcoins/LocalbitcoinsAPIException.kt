package com.localbitcoins

data class LocalbitcoinsApiErrorMessage(
    val message: String,
    val errorCode: Int
)

data class LocalbitcoinsAPIError(
    val error: LocalbitcoinsApiErrorMessage
)

class LocalbitcoinsAPIException(message: String, throwable: Throwable, val error: LocalbitcoinsAPIError? = null) :
    Exception(message, throwable)
