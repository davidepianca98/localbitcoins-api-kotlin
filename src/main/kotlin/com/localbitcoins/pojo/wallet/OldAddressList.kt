package com.localbitcoins.pojo.wallet

import java.math.BigDecimal

data class OldAddressList (
    val received: BigDecimal,
    val address: String
)
