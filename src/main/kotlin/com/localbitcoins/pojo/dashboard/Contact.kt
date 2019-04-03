package com.localbitcoins.pojo.dashboard

import com.fasterxml.jackson.annotation.*
import java.io.Serializable
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("data", "actions")
class Contact : Serializable {

    @JsonProperty("data")
    @get:JsonProperty("data")
    @set:JsonProperty("data")
    var data: ContactData = ContactData()
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

    override fun toString(): String {
        return "Contact(data=$data,actions=$actions,additionalProperties=$additionalProperties)"
    }
}
