package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("contact_list", "contact_count")
class DashboardData {

    @JsonProperty("contact_list")
    @get:JsonProperty("contact_list")
    @set:JsonProperty("contact_list")
    var contact: List<Contact>? = null
    @JsonProperty("contact_count")
    @get:JsonProperty("contact_count")
    @set:JsonProperty("contact_count")
    var contactCount: Int? = null
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
