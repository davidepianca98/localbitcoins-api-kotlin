package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("data")
class Advertisements {

    @JsonProperty("data")
    @get:JsonProperty("data")
    @set:JsonProperty("data")
    var advertismentsData: AdvertismentsData? = null
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
