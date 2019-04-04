package com.localbitcoins.pojo.fees

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Data (
    @JsonProperty("deposit_fee")
    val depositFee: BigDecimal,
    @JsonProperty("outgoing_fee")
    val outgoingFee: BigDecimal
)
