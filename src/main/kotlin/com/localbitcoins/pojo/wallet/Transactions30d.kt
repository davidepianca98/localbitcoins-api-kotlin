package com.localbitcoins.pojo.wallet

import java.math.BigDecimal
import java.util.*

data class Transactions30d (
    val amount: BigDecimal,
    val toAddress: String?,
    val description: String,
    val createdAt: Date,
    val txType: Int,
    var txid: String?
)
