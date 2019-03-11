package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("ad_list", "ad_count")
class AdvertismentsData {

    @JsonProperty("ad_list")
    @get:JsonProperty("ad_list")
    @set:JsonProperty("ad_list")
    var advertisment: List<Advertisment>? = null
    @JsonProperty("ad_count")
    @get:JsonProperty("ad_count")
    @set:JsonProperty("ad_count")
    var adCount: Int? = null
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
