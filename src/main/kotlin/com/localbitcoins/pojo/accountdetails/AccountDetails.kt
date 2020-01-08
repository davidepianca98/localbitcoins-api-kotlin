package com.localbitcoins.pojo.accountdetails

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AccountDetails(
    val receiverEmail: String?
)
