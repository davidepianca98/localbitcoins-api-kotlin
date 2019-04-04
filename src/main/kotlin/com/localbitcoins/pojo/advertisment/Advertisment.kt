package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Advertisment (
    @JsonProperty("data")
    val data: AdvertismentData,
    @JsonProperty("actions")
    val actions: Actions
)
