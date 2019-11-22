package com.localbitcoins

import com.fasterxml.jackson.annotation.JsonProperty

data class LocalbitcoinsApiErrorMessage(
    val message: String,
    @JsonProperty("error_code")
    val errorCode: Int
)

data class LocalbitcoinsAPIError(
    val error: LocalbitcoinsApiErrorMessage
)

class LocalbitcoinsAPIException(message: String, throwable: Throwable, val error: LocalbitcoinsAPIError? = null) :
    Exception(message, throwable)
