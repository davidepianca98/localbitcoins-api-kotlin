package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.localbitcoins.pojo.Profile
import java.io.Serializable

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Advertisement (
    @JsonProperty("payment_method")
    val paymentMethod: String?,
    @JsonProperty("advertiser")
    val advertiser: Profile,
    @JsonProperty("trade_type")
    val tradeType: String,
    @JsonProperty("id")
    val id: Int
): Serializable
