package com.localbitcoins.pojo.wallet

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Transactions30d (
    @JsonProperty("amount")
    val amount: BigDecimal,
    @JsonProperty("to_address")
    val toAddress: String?,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("created_at")
    val createdAt: Date,
    @JsonProperty("tx_type")
    val txType: Int,
    @JsonProperty("txid")
    var txid: String?
)
