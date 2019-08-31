package com.localbitcoins.pojo.accountdetails

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AccountDetails(
    @JsonProperty("receiver_email")
    val receiverEmail: String?
)
