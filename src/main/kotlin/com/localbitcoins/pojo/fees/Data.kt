package com.localbitcoins.pojo.fees

import java.math.BigDecimal

data class Data (
    val depositFee: BigDecimal,
    val outgoingFee: BigDecimal
)
