package com.localbitcoins.pojo.wallet

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
data class OldAddressList (
    @JsonProperty("received")
    val received: BigDecimal,
    @JsonProperty("address")
    val address: String
)
