package com.localbitcoins.pojo.wallet

import java.math.BigDecimal

data class Total (
    val balance: BigDecimal,
    val sendable: BigDecimal
)
