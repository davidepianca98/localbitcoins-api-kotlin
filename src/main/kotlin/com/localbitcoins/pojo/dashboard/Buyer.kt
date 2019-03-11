package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder(
    "username",
    "feedback_score",
    "name",
    "last_online",
    "countrycode_by_phone_number",
    "trade_count",
    "real_name",
    "countrycode_by_ip"
)
class Buyer {

    @JsonProperty("username")
    @get:JsonProperty("username")
    @set:JsonProperty("username")
    var username: String? = null
    @JsonProperty("feedback_score")
    @get:JsonProperty("feedback_score")
    @set:JsonProperty("feedback_score")
    var feedbackScore: Int? = null
    @JsonProperty("name")
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    var name: String? = null
    @JsonProperty("last_online")
    @get:JsonProperty("last_online")
    @set:JsonProperty("last_online")
    var lastOnline: String? = null
    @JsonProperty("countrycode_by_phone_number")
    @get:JsonProperty("countrycode_by_phone_number")
    @set:JsonProperty("countrycode_by_phone_number")
    var countrycodeByPhoneNumber: String? = null
    @JsonProperty("trade_count")
    @get:JsonProperty("trade_count")
    @set:JsonProperty("trade_count")
    var tradeCount: String? = null
    @JsonProperty("real_name")
    @get:JsonProperty("real_name")
    @set:JsonProperty("real_name")
    var realName: String? = null
    @JsonProperty("countrycode_by_ip")
    @get:JsonProperty("countrycode_by_ip")
    @set:JsonProperty("countrycode_by_ip")
    var countrycodeByIp: String? = null
    @JsonIgnore
    private val additionalProperties = HashMap<String, Any?>()

    @JsonAnyGetter
    fun getAdditionalProperties(): Map<String, Any?> {
        return this.additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any?) {
        this.additionalProperties[name] = value
    }

}
