package com.localbitcoins.pojo.wallet

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Data (

    @JsonProperty("receiving_address")
    val receivingAddress: String,
    @JsonProperty("received_transactions_30d")
    val receivedTransactions30d: List<Transactions30d>? = null,
    @JsonProperty("old_address_list")
    val oldAddressList: List<OldAddressList>,
    @JsonProperty("sent_transactions_30d")
    val sentTransactions30d: List<Transactions30d>? = null,
    @JsonProperty("message")
    val message: String,
    @JsonProperty("total")
    val total: Total
)
