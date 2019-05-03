package com.localbitcoins.pojo

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Profile (
    @JsonProperty("username")
    val username: String,
    @JsonProperty("feedback_score")
    val feedbackScore: Int,
    @JsonProperty("name")
    val name: String,
    @JsonProperty("last_online")
    val lastOnline: Date,
    @JsonProperty("trade_count")
    val tradeCount: String,
    @JsonProperty("countrycode_by_phone_number")
    val countrycodeByPhoneNumber: String? = null,
    @JsonProperty("real_name")
    val realName: String? = null,
    @JsonProperty("countrycode_by_ip")
    val countrycodeByIp: String? = null,
    @JsonProperty("company_name")
    val companyName: String? = null
): Serializable
