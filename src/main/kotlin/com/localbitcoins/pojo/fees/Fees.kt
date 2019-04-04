package com.localbitcoins.pojo.fees

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Fees (
    @JsonProperty("data")
    val data: Data
)
