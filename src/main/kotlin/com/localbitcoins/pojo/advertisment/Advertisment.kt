package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("data", "actions")
class Advertisment {

    @JsonProperty("data")
    @get:JsonProperty("data")
    @set:JsonProperty("data")
    var data: AdvertismentData? = null
    @JsonProperty("actions")
    @get:JsonProperty("actions")
    @set:JsonProperty("actions")
    var actions: Actions? = null
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
