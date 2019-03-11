package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("pagination", "data")
class LocalBitcoinsDashboard {

    @JsonProperty("pagination")
    @get:JsonProperty("pagination")
    @set:JsonProperty("pagination")
    var pagination: Pagination? = null
    @JsonProperty("data")
    @get:JsonProperty("data")
    @set:JsonProperty("data")
    var data: DashboardData? = null
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
