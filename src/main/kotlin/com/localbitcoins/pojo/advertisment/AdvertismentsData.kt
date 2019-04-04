package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class AdvertismentsData (
    @JsonProperty("ad_list")
    val advertismentList: List<Advertisment>,
    @JsonProperty("ad_count")
    val adCount: Int
)
