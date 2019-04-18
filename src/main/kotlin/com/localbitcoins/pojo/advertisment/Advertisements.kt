package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Advertisements (
    @JsonProperty("data")
    val advertismentsData: AdvertismentsData
)