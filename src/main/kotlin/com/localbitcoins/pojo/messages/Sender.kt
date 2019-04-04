package com.localbitcoins.pojo.messages

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Sender (
    @JsonProperty("username")
    val username: String,
    @JsonProperty("feedback_score")
    val feedbackScore: Int,
    @JsonProperty("trade_count")
    val tradeCount: String,
    @JsonProperty("last_online")
    val lastOnline: String,
    @JsonProperty("name")
    val name: String
)
