package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("payment_method", "advertiser", "trade_type", "id")
class Advertisement : Serializable {

    @JsonProperty("payment_method")
    @get:JsonProperty("payment_method")
    @set:JsonProperty("payment_method")
    var paymentMethod: String? = null
    @JsonProperty("advertiser")
    @get:JsonProperty("advertiser")
    @set:JsonProperty("advertiser")
    var advertiser: Advertiser? = null
    @JsonProperty("trade_type")
    @get:JsonProperty("trade_type")
    @set:JsonProperty("trade_type")
    var tradeType: String? = null
    @JsonProperty("id")
    @get:JsonProperty("id")
    @set:JsonProperty("id")
    var id: Int? = null
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
