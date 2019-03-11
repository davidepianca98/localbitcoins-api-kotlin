package com.localbitcoins.pojo.advertisment

import com.fasterxml.jackson.annotation.*
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("html_form", "public_view", "change_form")
class Actions {

    @JsonProperty("html_form")
    @get:JsonProperty("html_form")
    @set:JsonProperty("html_form")
    var htmlForm: String? = null
    @JsonProperty("public_view")
    @get:JsonProperty("public_view")
    @set:JsonProperty("public_view")
    var publicView: String? = null
    @JsonProperty("change_form")
    @get:JsonProperty("change_form")
    @set:JsonProperty("change_form")
    var changeForm: String? = null
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
