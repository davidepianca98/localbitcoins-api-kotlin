package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("username", "feedback_score", "trade_count", "last_online", "name")
class Seller {

    @JsonProperty("username")
    @get:JsonProperty("username")
    @set:JsonProperty("username")
    var username: String? = null
    @JsonProperty("feedback_score")
    @get:JsonProperty("feedback_score")
    @set:JsonProperty("feedback_score")
    var feedbackScore: Int? = null
    @JsonProperty("trade_count")
    @get:JsonProperty("trade_count")
    @set:JsonProperty("trade_count")
    var tradeCount: String? = null
    @JsonProperty("last_online")
    @get:JsonProperty("last_online")
    @set:JsonProperty("last_online")
    var lastOnline: String? = null
    @JsonProperty("name")
    @get:JsonProperty("name")
    @set:JsonProperty("name")
    var name: String? = null
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
