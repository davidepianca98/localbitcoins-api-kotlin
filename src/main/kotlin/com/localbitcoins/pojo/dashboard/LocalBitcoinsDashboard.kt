package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class LocalBitcoinsDashboard (
    @JsonProperty("pagination")
    val pagination: Pagination?,
    @JsonProperty("data")
    val data: DashboardData
)
