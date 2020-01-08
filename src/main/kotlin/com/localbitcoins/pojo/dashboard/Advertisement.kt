package com.localbitcoins.pojo.dashboard

import com.localbitcoins.pojo.Profile
import java.io.Serializable

data class Advertisement (
    val paymentMethod: String?,
    val advertiser: Profile,
    val tradeType: String,
    val id: Int
): Serializable
