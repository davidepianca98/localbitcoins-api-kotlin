package com.localbitcoins.pojo.wallet

import com.fasterxml.jackson.annotation.JsonProperty

data class Data (
    val receivingAddress: String,
    @JsonProperty("received_transactions_30d")
    val receivedTransactions30d: List<Transactions30d>? = null,
    val oldAddressList: List<OldAddressList>,
    @JsonProperty("sent_transactions_30d")
    val sentTransactions30d: List<Transactions30d>? = null,
    val message: String,
    val total: Total
)
