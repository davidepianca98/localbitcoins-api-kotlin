package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DashboardData (
    @JsonProperty("contact_list")
    val contact: List<Contact>,
    @JsonProperty("contact_count")
    val contactCount: Int
)
