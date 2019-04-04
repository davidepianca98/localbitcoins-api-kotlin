package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Pagination(
        @JsonProperty("next")
        val next: String?,
        @JsonProperty("prev")
        val prev: String?
)
